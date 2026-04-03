package backtrace.io.backtrace_unity_android_plugin;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class BacktraceCrashHelper {
    private static void InternalCall() {
        Log.d("BacktraceCrashHelper", String.valueOf(new int[]{10, 20, 30, 40}[5]));
    }

    public static void StartAnr() {
        Log.d("BacktraceCrashHelper", "Starting ANR");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: backtrace.io.backtrace_unity_android_plugin.BacktraceCrashHelper.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
        });
    }

    public static void ThrowNativeException() {
        Log.d("BacktraceCrashHelper", "Trying to throw native exception");
        InternalCall();
    }

    public void throwBackgroundJavaException() {
        Log.d("BacktraceCrashHelper", "throwing an unhandled background java exception");
        new Thread(new Runnable() { // from class: backtrace.io.backtrace_unity_android_plugin.BacktraceCrashHelper.1
            @Override // java.lang.Runnable
            public void run() {
                Log.d("BacktraceCrashHelper", String.valueOf(new int[]{10, 20, 30, 40}[5]));
            }
        }).start();
    }

    public void throwRuntimeException() {
        Log.d("BacktraceCrashHelper", "Throwing runtime exception");
        throw new RuntimeException("Unity-test: Uncaught JVM exception");
    }
}
