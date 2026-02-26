package com.ironsource;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class dk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f11847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11848b;

    public dk(@Nullable String str, int i10) {
        this.f11847a = str;
        this.f11848b = i10;
    }

    private final String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        kotlin.jvm.internal.t.h(stackTrace, "stackTrace");
        String strA = a(stackTrace, 6);
        String strB = b(stackTrace, 6);
        kotlin.jvm.internal.s0 s0Var = kotlin.jvm.internal.s0.f29840a;
        String str = String.format("%s %s", Arrays.copyOf(new Object[]{strA, strB}, 2));
        kotlin.jvm.internal.t.h(str, "format(format, *args)");
        return str;
    }

    public final int a() {
        return this.f11848b;
    }

    @NotNull
    public final String c() {
        String str = this.f11847a;
        if (str == null || str.length() == 0) {
            return b();
        }
        return b() + " - " + this.f11847a;
    }

    private final String a(StackTraceElement[] stackTraceElementArr, int i10) {
        List listL;
        List listL2;
        if (stackTraceElementArr.length <= i10) {
            return "";
        }
        String className = stackTraceElementArr[i10].getClassName();
        kotlin.jvm.internal.t.h(className, "stackTrace[depth]\n              .className");
        List<String> listD = new p9.f("\\.").d(className, 0);
        if (listD.isEmpty()) {
            listL = kotlin.collections.v.l();
        } else {
            ListIterator<String> listIterator = listD.listIterator(listD.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    listL = kotlin.collections.d0.J0(listD, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listL = kotlin.collections.v.l();
        }
        String[] strArr = (String[]) listL.toArray(new String[0]);
        String str = strArr[strArr.length - 1];
        if (!p9.r.P(str, "$", false, 2, null)) {
            return str;
        }
        List<String> listD2 = new p9.f("\\$").d(str, 0);
        if (listD2.isEmpty()) {
            listL2 = kotlin.collections.v.l();
        } else {
            ListIterator<String> listIterator2 = listD2.listIterator(listD2.size());
            while (listIterator2.hasPrevious()) {
                if (!(listIterator2.previous().length() == 0)) {
                    listL2 = kotlin.collections.d0.J0(listD2, listIterator2.nextIndex() + 1);
                    break;
                }
            }
            listL2 = kotlin.collections.v.l();
        }
        return ((String[]) listL2.toArray(new String[0]))[0];
    }

    private final String b(StackTraceElement[] stackTraceElementArr, int i10) {
        List listL;
        int i11;
        List listL2;
        List listL3;
        if (stackTraceElementArr.length <= i10) {
            return "";
        }
        String className = stackTraceElementArr[i10].getClassName();
        kotlin.jvm.internal.t.h(className, "stackTrace[depth]\n              .className");
        List<String> listD = new p9.f("\\.").d(className, 0);
        if (listD.isEmpty()) {
            listL = kotlin.collections.v.l();
        } else {
            ListIterator<String> listIterator = listD.listIterator(listD.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    listL = kotlin.collections.d0.J0(listD, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listL = kotlin.collections.v.l();
        }
        String[] strArr = (String[]) listL.toArray(new String[0]);
        String str = strArr[strArr.length - 1];
        if (p9.r.P(str, "$", false, 2, null)) {
            List<String> listD2 = new p9.f("\\$").d(str, 0);
            if (listD2.isEmpty()) {
                listL3 = kotlin.collections.v.l();
            } else {
                ListIterator<String> listIterator2 = listD2.listIterator(listD2.size());
                while (listIterator2.hasPrevious()) {
                    if (!(listIterator2.previous().length() == 0)) {
                        listL3 = kotlin.collections.d0.J0(listD2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
                listL3 = kotlin.collections.v.l();
            }
            return ((String[]) listL3.toArray(new String[0]))[1] + '.' + stackTraceElementArr[i10].getMethodName();
        }
        String methodName = stackTraceElementArr[i10].getMethodName();
        kotlin.jvm.internal.t.h(methodName, "stackTrace[depth].methodName");
        if (!p9.r.P(methodName, "$", false, 2, null) || stackTraceElementArr.length <= (i11 = i10 + 1)) {
            String methodName2 = stackTraceElementArr[i10].getMethodName();
            kotlin.jvm.internal.t.h(methodName2, "stackTrace[depth].methodName");
            return methodName2;
        }
        String className2 = stackTraceElementArr[i11].getClassName();
        kotlin.jvm.internal.t.h(className2, "stackTrace[depth + 1]\n                .className");
        List<String> listD3 = new p9.f("\\$").d(className2, 0);
        if (listD3.isEmpty()) {
            listL2 = kotlin.collections.v.l();
        } else {
            ListIterator<String> listIterator3 = listD3.listIterator(listD3.size());
            while (listIterator3.hasPrevious()) {
                if (!(listIterator3.previous().length() == 0)) {
                    listL2 = kotlin.collections.d0.J0(listD3, listIterator3.nextIndex() + 1);
                    break;
                }
            }
            listL2 = kotlin.collections.v.l();
        }
        String[] strArr2 = (String[]) listL2.toArray(new String[0]);
        if (strArr2.length <= 1) {
            String methodName3 = stackTraceElementArr[i11].getMethodName();
            kotlin.jvm.internal.t.h(methodName3, "{\n              stackTra….methodName\n            }");
            return methodName3;
        }
        return strArr2[1] + '.' + stackTraceElementArr[i11].getMethodName();
    }
}
