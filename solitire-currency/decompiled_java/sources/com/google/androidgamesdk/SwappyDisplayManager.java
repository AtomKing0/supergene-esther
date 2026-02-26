package com.google.androidgamesdk;

import android.app.Activity;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.media3.common.C;

/* JADX INFO: loaded from: classes3.dex */
public class SwappyDisplayManager implements DisplayManager.DisplayListener {
    private Activity mActivity;
    private long mCookie;
    private Display.Mode mCurrentMode;
    private d mLooper;
    private WindowManager mWindowManager;
    private final String LOG_TAG = "SwappyDisplayManager";
    private final boolean DEBUG = false;
    private final long ONE_MS_IN_NS = 1000000;
    private final long ONE_S_IN_NS = C.NANOS_PER_SECOND;

    public SwappyDisplayManager(long j10, Activity activity) {
        String string;
        try {
            Bundle bundle = activity.getPackageManager().getActivityInfo(activity.getIntent().getComponent(), 128).metaData;
            if (bundle != null && (string = bundle.getString("android.app.lib_name")) != null) {
                System.loadLibrary(string);
            }
        } catch (Throwable th) {
            Log.e("SwappyDisplayManager", th.getMessage());
        }
        this.mCookie = j10;
        this.mActivity = activity;
        WindowManager windowManager = (WindowManager) activity.getSystemService(WindowManager.class);
        this.mWindowManager = windowManager;
        Display defaultDisplay = windowManager.getDefaultDisplay();
        this.mCurrentMode = defaultDisplay.getMode();
        updateSupportedRefreshRates(defaultDisplay);
        DisplayManager displayManager = (DisplayManager) this.mActivity.getSystemService(DisplayManager.class);
        synchronized (this) {
            d dVar = new d();
            this.mLooper = dVar;
            dVar.start();
            displayManager.registerDisplayListener(this, this.mLooper.f9970a);
        }
    }

    private boolean modeMatchesCurrentResolution(Display.Mode mode) {
        return mode.getPhysicalHeight() == this.mCurrentMode.getPhysicalHeight() && mode.getPhysicalWidth() == this.mCurrentMode.getPhysicalWidth();
    }

    private native void nOnRefreshPeriodChanged(long j10, long j11, long j12, long j13);

    private native void nSetSupportedRefreshPeriods(long j10, long[] jArr, int[] iArr);

    private void updateSupportedRefreshRates(Display display) {
        Display.Mode[] supportedModes = display.getSupportedModes();
        int i10 = 0;
        for (Display.Mode mode : supportedModes) {
            if (modeMatchesCurrentResolution(mode)) {
                i10++;
            }
        }
        long[] jArr = new long[i10];
        int[] iArr = new int[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < supportedModes.length; i12++) {
            if (modeMatchesCurrentResolution(supportedModes[i12])) {
                jArr[i11] = (long) (1.0E9f / supportedModes[i12].getRefreshRate());
                iArr[i11] = supportedModes[i12].getModeId();
                i11++;
            }
        }
        nSetSupportedRefreshPeriods(this.mCookie, jArr, iArr);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int i10) {
        synchronized (this) {
            Display defaultDisplay = this.mWindowManager.getDefaultDisplay();
            float refreshRate = defaultDisplay.getRefreshRate();
            Display.Mode mode = defaultDisplay.getMode();
            boolean z10 = true;
            boolean z11 = (mode.getPhysicalWidth() != this.mCurrentMode.getPhysicalWidth()) | (mode.getPhysicalHeight() != this.mCurrentMode.getPhysicalHeight());
            if (refreshRate == this.mCurrentMode.getRefreshRate()) {
                z10 = false;
            }
            this.mCurrentMode = mode;
            if (z11) {
                updateSupportedRefreshRates(defaultDisplay);
            }
            if (z10) {
                long j10 = (long) (1.0E9f / refreshRate);
                nOnRefreshPeriodChanged(this.mCookie, j10, defaultDisplay.getAppVsyncOffsetNanos(), j10 - (this.mWindowManager.getDefaultDisplay().getPresentationDeadlineNanos() - 1000000));
            }
        }
    }

    public void setPreferredDisplayModeId(int i10) {
        this.mActivity.runOnUiThread(new c(this, i10));
    }

    public void terminate() {
        this.mLooper.f9970a.getLooper().quit();
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i10) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i10) {
    }
}
