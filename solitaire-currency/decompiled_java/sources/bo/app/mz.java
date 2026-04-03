package bo.app;

import android.content.Context;
import bo.app.mz;
import com.braze.support.BrazeLogger;
import com.braze.support.ReflectionUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import java.lang.reflect.Method;
import v8.s;

/* JADX INFO: loaded from: classes2.dex */
public final class mz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z00 f3455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v8.l f3456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v8.l f3457c;

    public mz(Context context, z00 registrationDataProvider) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(registrationDataProvider, "registrationDataProvider");
        this.f3455a = registrationDataProvider;
        this.f3456b = v8.n.a(zy.f4489a);
        this.f3457c = v8.n.a(az.f2406a);
    }

    public final void a(String firebaseSenderId) {
        kotlin.jvm.internal.t.i(firebaseSenderId, "firebaseSenderId");
        try {
            if (((Boolean) this.f3457c.getValue()).booleanValue()) {
                FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: i.d0
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        mz.a(this.f26530a, task);
                    }
                });
            } else if (((Boolean) this.f3456b.getValue()).booleanValue()) {
                b(firebaseSenderId);
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) dz.f2692a, 4, (Object) null);
        }
    }

    public final void b(String str) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new ez(str), 6, (Object) null);
        try {
            Method methodQuietly = ReflectionUtils.getMethodQuietly("com.google.firebase.iid.FirebaseInstanceId", "getInstance", (Class<?>[]) new Class[0]);
            if (methodQuietly == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) fz.f2849a, 7, (Object) null);
                return;
            }
            s<Boolean, Object> sVarInvokeMethodQuietly = ReflectionUtils.invokeMethodQuietly(null, methodQuietly, new Object[0]);
            if (!sVarInvokeMethodQuietly.c().booleanValue()) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) gz.f2939a, 7, (Object) null);
                return;
            }
            Object objD = sVarInvokeMethodQuietly.d();
            if (objD == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) hz.f3009a, 7, (Object) null);
                return;
            }
            Method methodQuietly2 = ReflectionUtils.getMethodQuietly(objD.getClass(), "getToken", (Class<?>[]) new Class[]{String.class, String.class});
            if (methodQuietly2 == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) iz.f3109a, 7, (Object) null);
                return;
            }
            s<Boolean, Object> sVarInvokeMethodQuietly2 = ReflectionUtils.invokeMethodQuietly(objD, methodQuietly2, str, FirebaseMessaging.INSTANCE_ID_SCOPE);
            if (!sVarInvokeMethodQuietly2.c().booleanValue()) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) jz.f3185a, 7, (Object) null);
                return;
            }
            Object objD2 = sVarInvokeMethodQuietly2.d();
            if (objD2 instanceof String) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new kz(objD2), 6, (Object) null);
                ((i70) this.f3455a).a((String) objD2);
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) lz.f3380a, 4, (Object) null);
        }
    }

    public static final void a(mz this$0, Task task) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(task, "task");
        if (!task.isSuccessful()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new bz(task), 6, (Object) null);
            return;
        }
        String str = (String) task.getResult();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new cz(str), 6, (Object) null);
        ((i70) this$0.f3455a).a(str);
    }
}
