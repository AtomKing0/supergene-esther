package l6;

import android.app.Activity;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.king.amp.sa.s0;

/* JADX INFO: compiled from: GoogleAdvertisingIdSource.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AsyncTaskC0622a f30902a;

    /* JADX INFO: renamed from: l6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GoogleAdvertisingIdSource.java */
    static class AsyncTaskC0622a extends AsyncTask<Void, Void, AdvertisingIdClient.Info> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Activity f30903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        AdvertisingIdClient.Info f30904b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f30905c = false;

        public AsyncTaskC0622a(Activity activity) {
            this.f30903a = activity;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdvertisingIdClient.Info doInBackground(Void... voidArr) {
            try {
                return AdvertisingIdClient.getAdvertisingIdInfo(this.f30903a.getApplicationContext());
            } catch (Exception unused) {
                return null;
            }
        }

        public AdvertisingIdClient.Info b() {
            return this.f30904b;
        }

        public boolean c() {
            return this.f30905c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(AdvertisingIdClient.Info info) {
            this.f30904b = info;
            this.f30905c = true;
        }
    }

    @Override // com.king.amp.sa.s0, com.king.amp.sa.p0
    public void a(Activity activity) {
        if (this.f30902a == null) {
            AsyncTaskC0622a asyncTaskC0622a = new AsyncTaskC0622a(activity);
            this.f30902a = asyncTaskC0622a;
            asyncTaskC0622a.execute(new Void[0]);
        }
    }

    @Override // com.king.amp.sa.s0, com.king.amp.sa.p0
    public boolean b() {
        AsyncTaskC0622a asyncTaskC0622a = this.f30902a;
        if (asyncTaskC0622a == null || asyncTaskC0622a.b() == null) {
            return false;
        }
        return !this.f30902a.b().isLimitAdTrackingEnabled();
    }

    @Override // com.king.amp.sa.s0, com.king.amp.sa.p0
    public String c() {
        AsyncTaskC0622a asyncTaskC0622a = this.f30902a;
        return (asyncTaskC0622a == null || asyncTaskC0622a.b() == null) ? super.c() : this.f30902a.b().getId();
    }

    @Override // com.king.amp.sa.s0, com.king.amp.sa.p0
    public boolean isLoaded() {
        AsyncTaskC0622a asyncTaskC0622a = this.f30902a;
        return asyncTaskC0622a != null && asyncTaskC0622a.c();
    }
}
