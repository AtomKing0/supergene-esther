package com.onetrust.otpublishers.headless.UI.adapter;

import androidx.recyclerview.widget.DiffUtil;

/* JADX INFO: loaded from: classes4.dex */
public final class s extends DiffUtil.ItemCallback<com.onetrust.otpublishers.headless.UI.DataModels.f> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(com.onetrust.otpublishers.headless.UI.DataModels.f fVar, com.onetrust.otpublishers.headless.UI.DataModels.f fVar2) {
        com.onetrust.otpublishers.headless.UI.DataModels.f oldItem = fVar;
        com.onetrust.otpublishers.headless.UI.DataModels.f newItem = fVar2;
        kotlin.jvm.internal.t.i(oldItem, "oldItem");
        kotlin.jvm.internal.t.i(newItem, "newItem");
        return kotlin.jvm.internal.t.d(oldItem.f22091b, newItem.f22091b) && oldItem.f22093d == newItem.f22093d;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(com.onetrust.otpublishers.headless.UI.DataModels.f fVar, com.onetrust.otpublishers.headless.UI.DataModels.f fVar2) {
        com.onetrust.otpublishers.headless.UI.DataModels.f oldItem = fVar;
        com.onetrust.otpublishers.headless.UI.DataModels.f newItem = fVar2;
        kotlin.jvm.internal.t.i(oldItem, "oldItem");
        kotlin.jvm.internal.t.i(newItem, "newItem");
        return kotlin.jvm.internal.t.d(oldItem.f22090a, newItem.f22090a);
    }
}
