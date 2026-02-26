package bitter.jnibridge;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class JNIBridge {
    static void disableInterfaceProxy(Object obj) {
        if (obj != null) {
            a aVar = (a) Proxy.getInvocationHandler(obj);
            synchronized (aVar.f2336a) {
                aVar.f2337b = 0L;
            }
        }
    }

    static native Object invoke(long j10, Class cls, Method method, Object[] objArr);

    static Object newInterfaceProxy(long j10, Class[] clsArr) {
        return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), clsArr, new a(j10));
    }
}
