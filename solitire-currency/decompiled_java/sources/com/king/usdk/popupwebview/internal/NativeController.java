package com.king.usdk.popupwebview.internal;

import androidx.annotation.Keep;
import com.king.usdk.popupwebview.ILoadingListener;
import com.king.usdk.popupwebview.IMessageListener;
import com.king.usdk.popupwebview.IResponder;
import com.king.usdk.popupwebview.IResponseCallback;
import com.king.usdk.popupwebview.Result;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
@Keep
final class NativeController extends Popup implements IMessageListener, ILoadingListener {
    private final Lock mNativeCallbackLock;
    private volatile long mNativeInstance;

    class a implements IResponseCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f17259a;

        a(long j10) {
            this.f17259a = j10;
        }

        @Override // com.king.usdk.popupwebview.IResponseCallback
        public void onMessageResponse(String str, Result result, String str2) {
            NativeController.this.mNativeCallbackLock.lock();
            try {
                if (NativeController.this.mNativeInstance != 0) {
                    NativeController nativeController = NativeController.this;
                    nativeController.onMessageResponse(nativeController.mNativeInstance, this.f17259a, str, result.ordinal(), str2);
                }
            } finally {
                NativeController.this.mNativeCallbackLock.unlock();
            }
        }
    }

    NativeController(ActivityWrapper activityWrapper, boolean z10) {
        super(activityWrapper, z10);
        this.mNativeCallbackLock = new ReentrantLock();
        this.mNativeInstance = 0L;
        super.setMessageListener(this);
        super.setLoadingListener(this);
    }

    private native void onBackButtonPressed(long j10);

    private native void onMessageReceived(long j10, String str, String str2, NativeResponder nativeResponder);

    /* JADX INFO: Access modifiers changed from: private */
    public native void onMessageResponse(long j10, long j11, String str, int i10, String str2);

    private native void onPageError(long j10, String str);

    private native void onPageLoaded(long j10, String str);

    public void disconnectFromNativeSide() {
        this.mNativeCallbackLock.lock();
        this.mNativeInstance = 0L;
        this.mNativeCallbackLock.unlock();
        dispose();
    }

    public void dispose() {
        recycleWebResources();
    }

    public int getPageStateAsInteger() {
        return getPageState().ordinal();
    }

    @Override // com.king.usdk.popupwebview.ILoadingListener
    public void onBackButtonPressed() {
        this.mNativeCallbackLock.lock();
        try {
            if (this.mNativeInstance != 0) {
                onBackButtonPressed(this.mNativeInstance);
            }
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    @Override // com.king.usdk.popupwebview.IMessageListener
    public void onMessageReceived(String str, String str2, IResponder iResponder) {
        NativeResponder nativeResponder = iResponder != null ? new NativeResponder(iResponder) : null;
        this.mNativeCallbackLock.lock();
        try {
            if (this.mNativeInstance != 0) {
                onMessageReceived(this.mNativeInstance, str, str2, nativeResponder);
            }
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    @Override // com.king.usdk.popupwebview.ILoadingListener
    public void onPageError(String str) {
        this.mNativeCallbackLock.lock();
        try {
            if (this.mNativeInstance != 0) {
                onPageError(this.mNativeInstance, str);
            }
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    @Override // com.king.usdk.popupwebview.ILoadingListener
    public void onPageLoaded(String str) {
        this.mNativeCallbackLock.lock();
        try {
            if (this.mNativeInstance != 0) {
                onPageLoaded(this.mNativeInstance, str);
            }
        } finally {
            this.mNativeCallbackLock.unlock();
        }
    }

    public void postMessage(String str, String str2, long j10) {
        if (j10 != 0) {
            super.postMessage(str, str2, new a(j10));
        } else {
            super.postMessage(str, str2, (IResponseCallback) null);
        }
    }

    public void setNativeInstance(long j10) {
        this.mNativeCallbackLock.lock();
        this.mNativeInstance = j10;
        this.mNativeCallbackLock.unlock();
    }

    @Override // com.king.usdk.popupwebview.internal.Popup, com.king.usdk.popupwebview.IPopup
    public void setLoadingListener(ILoadingListener iLoadingListener) {
    }

    @Override // com.king.usdk.popupwebview.internal.Popup, com.king.usdk.popupwebview.IPopup
    public void setMessageListener(IMessageListener iMessageListener) {
    }
}
