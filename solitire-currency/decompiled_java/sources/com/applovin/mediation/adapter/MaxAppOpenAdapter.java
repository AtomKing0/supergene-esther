package com.applovin.mediation.adapter;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;

/* JADX INFO: loaded from: classes2.dex */
public interface MaxAppOpenAdapter {
    void loadAppOpenAd(@NonNull MaxAdapterResponseParameters maxAdapterResponseParameters, @Nullable Activity activity, @NonNull MaxAppOpenAdapterListener maxAppOpenAdapterListener);

    void showAppOpenAd(@NonNull MaxAdapterResponseParameters maxAdapterResponseParameters, @Nullable Activity activity, @NonNull MaxAppOpenAdapterListener maxAppOpenAdapterListener);
}
