package com.moloco.sdk.internal.ortb;

import com.moloco.sdk.internal.ortb.model.e;
import com.moloco.sdk.internal.ortb.model.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.w;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.f;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f17677a = new f("\\$\\{AUCTION_PRICE\\}");

    @NotNull
    public static final e a(@NotNull e eVar) {
        t.i(eVar, "<this>");
        List<r> listC = eVar.c();
        ArrayList arrayList = new ArrayList(w.v(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            List<com.moloco.sdk.internal.ortb.model.c> listC2 = ((r) it.next()).c();
            ArrayList arrayList2 = new ArrayList(w.v(listC2, 10));
            for (com.moloco.sdk.internal.ortb.model.c cVar : listC2) {
                float fE = cVar.e();
                String strB = b(cVar.a(), Float.valueOf(fE));
                String strC = cVar.c();
                arrayList2.add(new com.moloco.sdk.internal.ortb.model.c(strB, fE, strC != null ? b(strC, Float.valueOf(fE)) : null, cVar.d()));
            }
            arrayList.add(new r(arrayList2));
        }
        return new e(arrayList);
    }

    @NotNull
    public static final String b(@NotNull String str, @Nullable Float f10) {
        String string;
        t.i(str, "<this>");
        f fVar = f17677a;
        if (f10 == null || (string = f10.toString()) == null) {
            string = "";
        }
        return fVar.b(str, string);
    }
}
