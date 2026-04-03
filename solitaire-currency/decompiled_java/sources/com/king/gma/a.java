package com.king.gma;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ Map.Entry a(Object obj, Object obj2) {
        Objects.requireNonNull(obj);
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }
}
