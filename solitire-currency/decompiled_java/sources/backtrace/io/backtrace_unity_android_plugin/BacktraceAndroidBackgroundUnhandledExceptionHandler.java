package backtrace.io.backtrace_unity_android_plugin;

import android.util.Log;
import com.unity3d.player.UnityPlayer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* JADX INFO: loaded from: classes2.dex */
public class BacktraceAndroidBackgroundUnhandledExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final transient String LOG_TAG = "BacktraceAndroidBackgroundUnhandledExceptionHandler";
    private final String _gameObject;
    private Throwable _lastCaughtBackgroundException;
    private Thread _lastCaughtBackgroundExceptionThread;
    private final String _methodName;
    private final Thread.UncaughtExceptionHandler mRootHandler;
    private volatile boolean shouldStop = false;

    public BacktraceAndroidBackgroundUnhandledExceptionHandler(String str, String str2) {
        Log.d(LOG_TAG, "Initializing Android unhandled exception handler");
        this._gameObject = str;
        this._methodName = str2;
        this.mRootHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private static void printStackTrace(StackTraceElement[] stackTraceElementArr, PrintWriter printWriter) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            printWriter.println(stackTraceElement);
        }
    }

    private static String stackTraceToString(StackTraceElement[] stackTraceElementArr) {
        StringWriter stringWriter = new StringWriter();
        printStackTrace(stackTraceElementArr, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void ReportThreadException(String str, String str2) {
        UnityPlayer.UnitySendMessage(this._gameObject, this._methodName, str + '\n' + str2);
        Log.d(LOG_TAG, "UnitySendMessageFinished. passing an exception object. Game object: " + this._gameObject + " method name: " + this._methodName);
    }

    public void finish() {
        if (this._lastCaughtBackgroundExceptionThread == null || this._lastCaughtBackgroundException == null) {
            Log.d(LOG_TAG, "The exception object or the exception thread is not available. This is probably a bug.");
        } else if (this.shouldStop) {
            Log.d(LOG_TAG, "Backtrace client has been disposed. The report won't be available.");
        } else {
            this.mRootHandler.uncaughtException(this._lastCaughtBackgroundExceptionThread, this._lastCaughtBackgroundException);
        }
    }

    public void stopMonitoring() {
        Log.d(LOG_TAG, "Uncaught exception handler has been disabled.");
        this.shouldStop = true;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this._lastCaughtBackgroundExceptionThread = thread;
        this._lastCaughtBackgroundException = th;
        if (this.shouldStop) {
            Log.d(LOG_TAG, "Background exception handler is disabled.");
            finish();
            return;
        }
        if (!(th instanceof Exception)) {
            Log.d(LOG_TAG, "Detected android crash. Using native crash reporter to report an error.");
            finish();
            return;
        }
        String name = th.getClass().getName();
        Log.d(LOG_TAG, "Detected unhandled background thread exception. Exception type: " + name + ". Reporting to Backtrace");
        ReportThreadException(name + " : " + th.getMessage(), stackTraceToString(th.getStackTrace()));
    }
}
