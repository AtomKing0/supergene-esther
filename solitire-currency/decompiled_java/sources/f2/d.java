package f2;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* JADX INFO: compiled from: JobInfoScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 21)
public class d implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f25594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g2.d f25595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f25596c;

    public d(Context context, g2.d dVar, f fVar) {
        this.f25594a = context;
        this.f25595b = dVar;
        this.f25596c = fVar;
    }

    private boolean d(JobScheduler jobScheduler, int i10, int i11) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i12 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i10) {
                return i12 >= i11;
            }
        }
        return false;
    }

    @Override // f2.x
    public void a(y1.o oVar, int i10) {
        b(oVar, i10, false);
    }

    @Override // f2.x
    public void b(y1.o oVar, int i10, boolean z10) {
        ComponentName componentName = new ComponentName(this.f25594a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f25594a.getSystemService("jobscheduler");
        int iC = c(oVar);
        if (!z10 && d(jobScheduler, iC, i10)) {
            c2.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", oVar);
            return;
        }
        long jD = this.f25595b.D(oVar);
        JobInfo.Builder builderC = this.f25596c.c(new JobInfo.Builder(iC, componentName), oVar.d(), jD, i10);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i10);
        persistableBundle.putString("backendName", oVar.b());
        persistableBundle.putInt("priority", j2.a.a(oVar.d()));
        if (oVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(oVar.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        c2.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", oVar, Integer.valueOf(iC), Long.valueOf(this.f25596c.g(oVar.d(), jD, i10)), Long.valueOf(jD), Integer.valueOf(i10));
        jobScheduler.schedule(builderC.build());
    }

    @VisibleForTesting
    int c(y1.o oVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f25594a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(oVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(j2.a.a(oVar.d())).array());
        if (oVar.c() != null) {
            adler32.update(oVar.c());
        }
        return (int) adler32.getValue();
    }
}
