package com.braze.storage;

/* JADX INFO: loaded from: classes2.dex */
public interface ICardStorageProvider<T> {
    void markCardAsClicked(String str);

    void markCardAsDismissed(String str);

    void markCardAsViewed(String str);

    void markCardAsVisuallyRead(String str);
}
