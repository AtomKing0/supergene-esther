package com.braze.support;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.w;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f8117a = new e();

    public static final Set a(EnumSet sourceEnumSet) {
        t.i(sourceEnumSet, "sourceEnumSet");
        ArrayList arrayList = new ArrayList(w.v(sourceEnumSet, 10));
        Iterator it = sourceEnumSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Enum) it.next()).name());
        }
        return d0.T0(arrayList);
    }
}
