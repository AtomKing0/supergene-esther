package com.unity3d.services.ads.operation.show;

import android.app.Activity;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.ads.operation.OperationState;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class ShowOperationState extends OperationState {
    public WeakReference<Activity> activity;
    public IUnityAdsShowListener listener;
    public UnityAdsShowOptions showOptions;

    public ShowOperationState(String str, IUnityAdsShowListener iUnityAdsShowListener, Activity activity, UnityAdsShowOptions unityAdsShowOptions, Configuration configuration) {
        super(str, configuration);
        this.listener = iUnityAdsShowListener;
        this.activity = new WeakReference<>(activity);
        this.showOptions = unityAdsShowOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUnityAdsShowClick$1() {
        this.listener.onUnityAdsShowClick(this.placementId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUnityAdsShowComplete$3(UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        this.listener.onUnityAdsShowComplete(this.placementId, unityAdsShowCompletionState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUnityAdsShowFailure$0(UnityAds.UnityAdsShowError unityAdsShowError, String str) {
        this.listener.onUnityAdsShowFailure(this.placementId, unityAdsShowError, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUnityAdsShowStart$2(String str) {
        this.listener.onUnityAdsShowStart(str);
    }

    public void onUnityAdsShowClick() {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f24281a.lambda$onUnityAdsShowClick$1();
                }
            });
        }
    }

    public void onUnityAdsShowComplete(final UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f24279a.lambda$onUnityAdsShowComplete$3(unityAdsShowCompletionState);
                }
            });
        }
    }

    public void onUnityAdsShowFailure(final UnityAds.UnityAdsShowError unityAdsShowError, final String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f24284a.lambda$onUnityAdsShowFailure$0(unityAdsShowError, str);
                }
            });
        }
    }

    public void onUnityAdsShowStart(final String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f24282a.lambda$onUnityAdsShowStart$2(str);
                }
            });
        }
    }
}
