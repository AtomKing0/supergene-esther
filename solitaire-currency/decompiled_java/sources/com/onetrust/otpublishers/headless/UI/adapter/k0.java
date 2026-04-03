package com.onetrust.otpublishers.headless.UI.adapter;

import androidx.recyclerview.widget.DiffUtil;

/* JADX INFO: loaded from: classes4.dex */
public final class k0 extends DiffUtil.ItemCallback<com.onetrust.otpublishers.headless.UI.DataModels.i> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(com.onetrust.otpublishers.headless.UI.DataModels.i iVar, com.onetrust.otpublishers.headless.UI.DataModels.i iVar2) {
        com.onetrust.otpublishers.headless.UI.DataModels.i oldItem = iVar;
        com.onetrust.otpublishers.headless.UI.DataModels.i newItem = iVar2;
        kotlin.jvm.internal.t.i(oldItem, "oldItem");
        kotlin.jvm.internal.t.i(newItem, "newItem");
        return kotlin.jvm.internal.t.d(oldItem.f22115b, newItem.f22115b) && oldItem.f22116c == newItem.f22116c;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(com.onetrust.otpublishers.headless.UI.DataModels.i iVar, com.onetrust.otpublishers.headless.UI.DataModels.i iVar2) {
        com.onetrust.otpublishers.headless.UI.DataModels.i oldItem = iVar;
        com.onetrust.otpublishers.headless.UI.DataModels.i newItem = iVar2;
        kotlin.jvm.internal.t.i(oldItem, "oldItem");
        kotlin.jvm.internal.t.i(newItem, "newItem");
        return kotlin.jvm.internal.t.d(oldItem.f22114a, newItem.f22114a);
    }
}
