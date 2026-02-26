package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzat extends zzal {
    static final zzal zza = new zzat(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzat(Object obj, Object[] objArr, int i10) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    static zzat zzg(int i10, Object[] objArr, zzak zzakVar) {
        int iHighestOneBit;
        short[] sArr;
        char c10;
        char c11;
        ?? r32;
        ?? r33;
        int i11 = i10;
        Object[] objArrCopyOf = objArr;
        if (i11 == 0) {
            return (zzat) zza;
        }
        zzaj zzajVar = null;
        ?? r34 = 0;
        zzaj zzajVar2 = null;
        zzaj zzajVar3 = null;
        int i12 = 1;
        if (i11 == 1) {
            Object obj = objArrCopyOf[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArrCopyOf[1];
            Objects.requireNonNull(obj2);
            zzad.zza(obj, obj2);
            return new zzat(null, objArrCopyOf, 1);
        }
        zzaa.zzb(i11, objArrCopyOf.length >> 1, "index");
        int iMax = Math.max(i11, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
        } else {
            iHighestOneBit = 1073741824;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i11 == 1) {
            Object obj3 = objArrCopyOf[0];
            Objects.requireNonNull(obj3);
            Object obj4 = objArrCopyOf[1];
            Objects.requireNonNull(obj4);
            zzad.zza(obj3, obj4);
            i11 = 1;
            c10 = 1;
            c11 = 2;
        } else {
            int i13 = iHighestOneBit - 1;
            byte b10 = -1;
            if (iHighestOneBit <= 128) {
                byte[] bArr = new byte[iHighestOneBit];
                Arrays.fill(bArr, (byte) -1);
                int i14 = 0;
                int i15 = 0;
                while (i14 < i11) {
                    int i16 = i15 + i15;
                    int i17 = i14 + i14;
                    Object obj5 = objArrCopyOf[i17];
                    Objects.requireNonNull(obj5);
                    Object obj6 = objArrCopyOf[i17 ^ i12];
                    Objects.requireNonNull(obj6);
                    zzad.zza(obj5, obj6);
                    int iZza = zzae.zza(obj5.hashCode());
                    while (true) {
                        int i18 = iZza & i13;
                        int i19 = bArr[i18] & 255;
                        if (i19 == 255) {
                            bArr[i18] = (byte) i16;
                            if (i15 < i14) {
                                objArrCopyOf[i16] = obj5;
                                objArrCopyOf[i16 ^ 1] = obj6;
                            }
                            i15++;
                        } else {
                            if (obj5.equals(objArrCopyOf[i19 == true ? 1 : 0])) {
                                int i20 = ~i19;
                                Object obj7 = objArrCopyOf[i20 == true ? 1 : 0];
                                Objects.requireNonNull(obj7);
                                zzaj zzajVar4 = new zzaj(obj5, obj6, obj7);
                                objArrCopyOf[i20 == true ? 1 : 0] = obj6;
                                zzajVar2 = zzajVar4;
                                break;
                            }
                            iZza = i18 + 1;
                        }
                    }
                    i14++;
                    i12 = 1;
                }
                if (i15 == i11) {
                    r32 = bArr;
                } else {
                    r33 = new Object[]{bArr, Integer.valueOf(i15), zzajVar2};
                    c11 = 2;
                    c10 = 1;
                    r34 = r33;
                }
            } else if (iHighestOneBit <= 32768) {
                sArr = new short[iHighestOneBit];
                Arrays.fill(sArr, (short) -1);
                int i21 = 0;
                for (int i22 = 0; i22 < i11; i22++) {
                    int i23 = i21 + i21;
                    int i24 = i22 + i22;
                    Object obj8 = objArrCopyOf[i24];
                    Objects.requireNonNull(obj8);
                    Object obj9 = objArrCopyOf[i24 ^ 1];
                    Objects.requireNonNull(obj9);
                    zzad.zza(obj8, obj9);
                    int iZza2 = zzae.zza(obj8.hashCode());
                    while (true) {
                        int i25 = iZza2 & i13;
                        char c12 = (char) sArr[i25];
                        if (c12 == 65535) {
                            sArr[i25] = (short) i23;
                            if (i21 < i22) {
                                objArrCopyOf[i23] = obj8;
                                objArrCopyOf[i23 ^ 1] = obj9;
                            }
                            i21++;
                        } else {
                            if (obj8.equals(objArrCopyOf[c12])) {
                                int i26 = c12 ^ 1;
                                Object obj10 = objArrCopyOf[i26 == true ? 1 : 0];
                                Objects.requireNonNull(obj10);
                                zzaj zzajVar5 = new zzaj(obj8, obj9, obj10);
                                objArrCopyOf[i26 == true ? 1 : 0] = obj9;
                                zzajVar3 = zzajVar5;
                                break;
                            }
                            iZza2 = i25 + 1;
                        }
                    }
                }
                if (i21 != i11) {
                    c11 = 2;
                    r34 = new Object[]{sArr, Integer.valueOf(i21), zzajVar3};
                    c10 = 1;
                }
                r32 = sArr;
            } else {
                int i27 = 1;
                sArr = new int[iHighestOneBit];
                Arrays.fill((int[]) sArr, -1);
                int i28 = 0;
                int i29 = 0;
                while (i28 < i11) {
                    int i30 = i29 + i29;
                    int i31 = i28 + i28;
                    Object obj11 = objArrCopyOf[i31];
                    Objects.requireNonNull(obj11);
                    Object obj12 = objArrCopyOf[i31 ^ i27];
                    Objects.requireNonNull(obj12);
                    zzad.zza(obj11, obj12);
                    int iZza3 = zzae.zza(obj11.hashCode());
                    while (true) {
                        int i32 = iZza3 & i13;
                        ?? r15 = sArr[i32];
                        if (r15 == b10) {
                            sArr[i32] = i30;
                            if (i29 < i28) {
                                objArrCopyOf[i30] = obj11;
                                objArrCopyOf[i30 ^ 1] = obj12;
                            }
                            i29++;
                        } else {
                            if (obj11.equals(objArrCopyOf[r15])) {
                                int i33 = r15 ^ 1;
                                Object obj13 = objArrCopyOf[i33 == true ? 1 : 0];
                                Objects.requireNonNull(obj13);
                                zzaj zzajVar6 = new zzaj(obj11, obj12, obj13);
                                objArrCopyOf[i33 == true ? 1 : 0] = obj12;
                                zzajVar = zzajVar6;
                                break;
                            }
                            iZza3 = i32 + 1;
                            b10 = -1;
                        }
                    }
                    i28++;
                    i27 = 1;
                    b10 = -1;
                }
                if (i29 != i11) {
                    c10 = 1;
                    c11 = 2;
                    r34 = new Object[]{sArr, Integer.valueOf(i29), zzajVar};
                }
                r32 = sArr;
            }
            c11 = 2;
            r33 = r32;
            c10 = 1;
            r34 = r33;
        }
        boolean z10 = r34 instanceof Object[];
        ?? r35 = r34;
        if (z10) {
            Object[] objArr2 = (Object[]) r34;
            zzaj zzajVar7 = (zzaj) objArr2[c11];
            if (zzakVar == null) {
                throw zzajVar7.zza();
            }
            zzakVar.zzc = zzajVar7;
            Object obj14 = objArr2[0];
            int iIntValue = ((Integer) objArr2[c10]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            r35 = obj14;
            i11 = iIntValue;
        }
        return new zzat(r35, objArrCopyOf, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x0038->B:22:0x004e], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0063->B:32:0x007a], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x0089->B:43:0x00a0]] */
    @Override // com.google.android.gms.internal.play_billing.zzal, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L6
        L3:
            r10 = r0
            goto L9c
        L6:
            int r1 = r9.zzd
            java.lang.Object[] r2 = r9.zzb
            r3 = 1
            if (r1 != r3) goto L20
            r1 = 0
            r1 = r2[r1]
            java.util.Objects.requireNonNull(r1)
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L3
            r10 = r2[r3]
            java.util.Objects.requireNonNull(r10)
            goto L9c
        L20:
            java.lang.Object r1 = r9.zzc
            if (r1 != 0) goto L25
            goto L3
        L25:
            boolean r4 = r1 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L51
            r4 = r1
            byte[] r4 = (byte[]) r4
            int r1 = r4.length
            int r6 = r1 + (-1)
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.play_billing.zzae.zza(r1)
        L38:
            r1 = r1 & r6
            r5 = r4[r1]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L41
            goto L3
        L41:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L4e
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9c
        L4e:
            int r1 = r1 + 1
            goto L38
        L51:
            boolean r4 = r1 instanceof short[]
            if (r4 == 0) goto L7d
            r4 = r1
            short[] r4 = (short[]) r4
            int r1 = r4.length
            int r6 = r1 + (-1)
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.play_billing.zzae.zza(r1)
        L63:
            r1 = r1 & r6
            short r5 = r4[r1]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6d
            goto L3
        L6d:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7a
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9c
        L7a:
            int r1 = r1 + 1
            goto L63
        L7d:
            int[] r1 = (int[]) r1
            int r4 = r1.length
            int r4 = r4 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.play_billing.zzae.zza(r6)
        L89:
            r6 = r6 & r4
            r7 = r1[r6]
            if (r7 != r5) goto L90
            goto L3
        L90:
            r8 = r2[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La0
            r10 = r7 ^ 1
            r10 = r2[r10]
        L9c:
            if (r10 != 0) goto L9f
            return r0
        L9f:
            return r10
        La0:
            int r6 = r6 + 1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzat.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzal
    final zzaf zza() {
        return new zzas(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzal
    final zzam zzd() {
        return new zzaq(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzal
    final zzam zze() {
        return new zzar(this, new zzas(this.zzb, 0, this.zzd));
    }
}
