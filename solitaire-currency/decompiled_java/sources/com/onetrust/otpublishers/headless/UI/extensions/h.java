package com.onetrust.otpublishers.headless.UI.extensions;

import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class h {
    public static final Object a(@NotNull MutableLiveData mutableLiveData) {
        t.i(mutableLiveData, "<this>");
        if (mutableLiveData.getValue() == 0) {
            throw new IllegalStateException("LiveData does not have any value");
        }
        T value = mutableLiveData.getValue();
        t.f(value);
        return value;
    }
}
