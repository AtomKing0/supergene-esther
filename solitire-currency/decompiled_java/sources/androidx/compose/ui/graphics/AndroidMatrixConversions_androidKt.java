package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidMatrixConversions.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidMatrixConversions_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
    /* JADX INFO: renamed from: setFrom-EL8BTi8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1479setFromEL8BTi8(@org.jetbrains.annotations.NotNull android.graphics.Matrix r23, @org.jetbrains.annotations.NotNull float[] r24) {
        /*
            r0 = r24
            java.lang.String r1 = "$this$setFrom"
            r2 = r23
            kotlin.jvm.internal.t.i(r2, r1)
            java.lang.String r1 = "matrix"
            kotlin.jvm.internal.t.i(r0, r1)
            r1 = 2
            r3 = r0[r1]
            r4 = 0
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            r6 = 1
            r7 = 0
            if (r5 != 0) goto L1a
            r5 = r6
            goto L1b
        L1a:
            r5 = r7
        L1b:
            r8 = 8
            r9 = 6
            if (r5 == 0) goto L6e
            r5 = r0[r9]
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L28
            r5 = r6
            goto L29
        L28:
            r5 = r7
        L29:
            if (r5 == 0) goto L6e
            r5 = 10
            r5 = r0[r5]
            r10 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 != 0) goto L37
            r5 = r6
            goto L38
        L37:
            r5 = r7
        L38:
            if (r5 == 0) goto L6e
            r5 = 14
            r5 = r0[r5]
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L44
            r5 = r6
            goto L45
        L44:
            r5 = r7
        L45:
            if (r5 == 0) goto L6e
            r5 = r0[r8]
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L4f
            r5 = r6
            goto L50
        L4f:
            r5 = r7
        L50:
            if (r5 == 0) goto L6e
            r5 = 9
            r5 = r0[r5]
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L5c
            r5 = r6
            goto L5d
        L5c:
            r5 = r7
        L5d:
            if (r5 == 0) goto L6e
            r5 = 11
            r5 = r0[r5]
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 != 0) goto L69
            r4 = r6
            goto L6a
        L69:
            r4 = r7
        L6a:
            if (r4 == 0) goto L6e
            r4 = r6
            goto L6f
        L6e:
            r4 = r7
        L6f:
            if (r4 == 0) goto Lba
            r4 = r0[r7]
            r5 = r0[r6]
            r10 = 3
            r11 = r0[r10]
            r12 = 4
            r13 = r0[r12]
            r14 = 5
            r15 = r0[r14]
            r16 = r0[r9]
            r17 = 7
            r18 = r0[r17]
            r19 = r0[r8]
            r20 = 12
            r20 = r0[r20]
            r21 = 13
            r21 = r0[r21]
            r22 = 15
            r22 = r0[r22]
            r0[r7] = r4
            r0[r6] = r13
            r0[r1] = r20
            r0[r10] = r5
            r0[r12] = r15
            r0[r14] = r21
            r0[r9] = r11
            r0[r17] = r18
            r0[r8] = r22
            r23.setValues(r24)
            r0[r7] = r4
            r0[r6] = r5
            r0[r1] = r3
            r0[r10] = r11
            r0[r12] = r13
            r0[r14] = r15
            r0[r9] = r16
            r0[r17] = r18
            r0[r8] = r19
            return
        Lba:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Android does not support arbitrary transforms"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt.m1479setFromEL8BTi8(android.graphics.Matrix, float[]):void");
    }

    /* JADX INFO: renamed from: setFrom-tU-YjHk, reason: not valid java name */
    public static final void m1480setFromtUYjHk(@NotNull float[] setFrom, @NotNull android.graphics.Matrix matrix) {
        kotlin.jvm.internal.t.i(setFrom, "$this$setFrom");
        kotlin.jvm.internal.t.i(matrix, "matrix");
        matrix.getValues(setFrom);
        float f10 = setFrom[0];
        float f11 = setFrom[1];
        float f12 = setFrom[2];
        float f13 = setFrom[3];
        float f14 = setFrom[4];
        float f15 = setFrom[5];
        float f16 = setFrom[6];
        float f17 = setFrom[7];
        float f18 = setFrom[8];
        setFrom[0] = f10;
        setFrom[1] = f13;
        setFrom[2] = 0.0f;
        setFrom[3] = f16;
        setFrom[4] = f11;
        setFrom[5] = f14;
        setFrom[6] = 0.0f;
        setFrom[7] = f17;
        setFrom[8] = 0.0f;
        setFrom[9] = 0.0f;
        setFrom[10] = 1.0f;
        setFrom[11] = 0.0f;
        setFrom[12] = f12;
        setFrom[13] = f15;
        setFrom[14] = 0.0f;
        setFrom[15] = f18;
    }
}
