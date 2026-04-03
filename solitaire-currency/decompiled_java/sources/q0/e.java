package q0;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import q0.a;

/* JADX INFO: compiled from: StandardGifDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f33099u = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ColorInt
    private int[] f33100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @ColorInt
    private final int[] f33101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a.InterfaceC0656a f33102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ByteBuffer f33103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f33104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short[] f33105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f33106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f33107h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f33108i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @ColorInt
    private int[] f33109j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f33110k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private c f33111l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Bitmap f33112m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f33113n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f33114o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f33115p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f33116q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f33117r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private Boolean f33118s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    private Bitmap.Config f33119t;

    public e(@NonNull a.InterfaceC0656a interfaceC0656a, c cVar, ByteBuffer byteBuffer, int i10) {
        this(interfaceC0656a);
        q(cVar, byteBuffer, i10);
    }

    @ColorInt
    private int i(int i10, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i10; i18 < this.f33115p + i10; i18++) {
            byte[] bArr = this.f33108i;
            if (i18 >= bArr.length || i18 >= i11) {
                break;
            }
            int i19 = this.f33100a[bArr[i18] & 255];
            if (i19 != 0) {
                i13 += (i19 >> 24) & 255;
                i14 += (i19 >> 16) & 255;
                i15 += (i19 >> 8) & 255;
                i16 += i19 & 255;
                i17++;
            }
        }
        int i20 = i10 + i12;
        for (int i21 = i20; i21 < this.f33115p + i20; i21++) {
            byte[] bArr2 = this.f33108i;
            if (i21 >= bArr2.length || i21 >= i11) {
                break;
            }
            int i22 = this.f33100a[bArr2[i21] & 255];
            if (i22 != 0) {
                i13 += (i22 >> 24) & 255;
                i14 += (i22 >> 16) & 255;
                i15 += (i22 >> 8) & 255;
                i16 += i22 & 255;
                i17++;
            }
        }
        if (i17 == 0) {
            return 0;
        }
        return ((i13 / i17) << 24) | ((i14 / i17) << 16) | ((i15 / i17) << 8) | (i16 / i17);
    }

    private void j(b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr = this.f33109j;
        int i15 = bVar.f33074d;
        int i16 = this.f33115p;
        int i17 = i15 / i16;
        int i18 = bVar.f33072b / i16;
        int i19 = bVar.f33073c / i16;
        int i20 = bVar.f33071a / i16;
        boolean z10 = this.f33110k == 0;
        int i21 = this.f33117r;
        int i22 = this.f33116q;
        byte[] bArr = this.f33108i;
        int[] iArr2 = this.f33100a;
        Boolean bool = this.f33118s;
        int i23 = 8;
        int i24 = 0;
        int i25 = 0;
        int i26 = 1;
        while (i25 < i17) {
            Boolean bool2 = bool;
            if (bVar.f33075e) {
                if (i24 >= i17) {
                    int i27 = i26 + 1;
                    i10 = i17;
                    if (i27 == 2) {
                        i24 = 4;
                    } else if (i27 == 3) {
                        i23 = 4;
                        i26 = i27;
                        i24 = 2;
                    } else if (i27 == 4) {
                        i26 = i27;
                        i24 = 1;
                        i23 = 2;
                    }
                    i26 = i27;
                } else {
                    i10 = i17;
                }
                i11 = i24 + i23;
            } else {
                i10 = i17;
                i11 = i24;
                i24 = i25;
            }
            int i28 = i24 + i18;
            boolean z11 = i16 == 1;
            if (i28 < i22) {
                int i29 = i28 * i21;
                int i30 = i29 + i20;
                int i31 = i30 + i19;
                int i32 = i29 + i21;
                if (i32 < i31) {
                    i31 = i32;
                }
                i12 = i11;
                int i33 = i25 * i16 * bVar.f33073c;
                if (z11) {
                    int i34 = i30;
                    while (i34 < i31) {
                        int i35 = i18;
                        int i36 = iArr2[bArr[i33] & 255];
                        if (i36 != 0) {
                            iArr[i34] = i36;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                        i34++;
                        i18 = i35;
                    }
                } else {
                    i14 = i18;
                    int i37 = ((i31 - i30) * i16) + i33;
                    int i38 = i30;
                    while (true) {
                        i13 = i19;
                        if (i38 < i31) {
                            int i39 = i(i33, i37, bVar.f33073c);
                            if (i39 != 0) {
                                iArr[i38] = i39;
                            } else if (z10 && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i33 += i16;
                            i38++;
                            i19 = i13;
                        }
                    }
                    bool = bool2;
                    i25++;
                    i18 = i14;
                    i17 = i10;
                    i19 = i13;
                    i24 = i12;
                }
            } else {
                i12 = i11;
            }
            i14 = i18;
            i13 = i19;
            bool = bool2;
            i25++;
            i18 = i14;
            i17 = i10;
            i19 = i13;
            i24 = i12;
        }
        Boolean bool3 = bool;
        if (this.f33118s == null) {
            this.f33118s = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    private void k(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.f33109j;
        int i10 = bVar2.f33074d;
        int i11 = bVar2.f33072b;
        int i12 = bVar2.f33073c;
        int i13 = bVar2.f33071a;
        boolean z10 = this.f33110k == 0;
        int i14 = this.f33117r;
        byte[] bArr = this.f33108i;
        int[] iArr2 = this.f33100a;
        int i15 = 0;
        byte b10 = -1;
        while (i15 < i10) {
            int i16 = (i15 + i11) * i14;
            int i17 = i16 + i13;
            int i18 = i17 + i12;
            int i19 = i16 + i14;
            if (i19 < i18) {
                i18 = i19;
            }
            int i20 = bVar2.f33073c * i15;
            int i21 = i17;
            while (i21 < i18) {
                byte b11 = bArr[i20];
                int i22 = i10;
                int i23 = b11 & 255;
                if (i23 != b10) {
                    int i24 = iArr2[i23];
                    if (i24 != 0) {
                        iArr[i21] = i24;
                    } else {
                        b10 = b11;
                    }
                }
                i20++;
                i21++;
                i10 = i22;
            }
            i15++;
            bVar2 = bVar;
        }
        Boolean bool = this.f33118s;
        this.f33118s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f33118s == null && z10 && b10 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void l(b bVar) {
        int i10;
        int i11;
        short s10;
        e eVar = this;
        if (bVar != null) {
            eVar.f33103d.position(bVar.f33080j);
        }
        if (bVar == null) {
            c cVar = eVar.f33111l;
            i10 = cVar.f33087f;
            i11 = cVar.f33088g;
        } else {
            i10 = bVar.f33073c;
            i11 = bVar.f33074d;
        }
        int i12 = i10 * i11;
        byte[] bArr = eVar.f33108i;
        if (bArr == null || bArr.length < i12) {
            eVar.f33108i = eVar.f33102c.b(i12);
        }
        byte[] bArr2 = eVar.f33108i;
        if (eVar.f33105f == null) {
            eVar.f33105f = new short[4096];
        }
        short[] sArr = eVar.f33105f;
        if (eVar.f33106g == null) {
            eVar.f33106g = new byte[4096];
        }
        byte[] bArr3 = eVar.f33106g;
        if (eVar.f33107h == null) {
            eVar.f33107h = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        byte[] bArr4 = eVar.f33107h;
        int iP = p();
        int i13 = 1 << iP;
        int i14 = i13 + 1;
        int i15 = i13 + 2;
        int i16 = iP + 1;
        int i17 = (1 << i16) - 1;
        int i18 = 0;
        for (int i19 = 0; i19 < i13; i19++) {
            sArr[i19] = 0;
            bArr3[i19] = (byte) i19;
        }
        byte[] bArr5 = eVar.f33104e;
        int i20 = i16;
        int i21 = i15;
        int i22 = i17;
        int iO = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = -1;
        while (true) {
            if (i18 >= i12) {
                break;
            }
            if (iO == 0) {
                iO = o();
                if (iO <= 0) {
                    eVar.f33114o = 3;
                    break;
                }
                i23 = 0;
            }
            i25 += (bArr5[i23] & 255) << i24;
            i23++;
            iO--;
            int i30 = i24 + 8;
            int i31 = i21;
            int i32 = i20;
            int i33 = i29;
            int i34 = i16;
            int i35 = i27;
            while (true) {
                if (i30 < i32) {
                    i29 = i33;
                    i21 = i31;
                    i24 = i30;
                    eVar = this;
                    i27 = i35;
                    i16 = i34;
                    i20 = i32;
                    break;
                }
                int i36 = i15;
                int i37 = i25 & i22;
                i25 >>= i32;
                i30 -= i32;
                if (i37 == i13) {
                    i22 = i17;
                    i32 = i34;
                    i31 = i36;
                    i15 = i31;
                    i33 = -1;
                } else {
                    if (i37 == i14) {
                        i24 = i30;
                        i27 = i35;
                        i21 = i31;
                        i16 = i34;
                        i15 = i36;
                        i29 = i33;
                        i20 = i32;
                        eVar = this;
                        break;
                    }
                    if (i33 == -1) {
                        bArr2[i26] = bArr3[i37];
                        i26++;
                        i18++;
                        i33 = i37;
                        i35 = i33;
                        i15 = i36;
                        i30 = i30;
                    } else {
                        if (i37 >= i31) {
                            bArr4[i28] = (byte) i35;
                            i28++;
                            s10 = i33;
                        } else {
                            s10 = i37;
                        }
                        while (s10 >= i13) {
                            bArr4[i28] = bArr3[s10];
                            i28++;
                            s10 = sArr[s10];
                        }
                        i35 = bArr3[s10] & 255;
                        byte b10 = (byte) i35;
                        bArr2[i26] = b10;
                        while (true) {
                            i26++;
                            i18++;
                            if (i28 <= 0) {
                                break;
                            }
                            i28--;
                            bArr2[i26] = bArr4[i28];
                        }
                        byte[] bArr6 = bArr4;
                        if (i31 < 4096) {
                            sArr[i31] = (short) i33;
                            bArr3[i31] = b10;
                            i31++;
                            if ((i31 & i22) == 0 && i31 < 4096) {
                                i32++;
                                i22 += i31;
                            }
                        }
                        i33 = i37;
                        i15 = i36;
                        i30 = i30;
                        bArr4 = bArr6;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i26, i12, (byte) 0);
    }

    private Bitmap n() {
        Boolean bool = this.f33118s;
        Bitmap bitmapC = this.f33102c.c(this.f33117r, this.f33116q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f33119t);
        bitmapC.setHasAlpha(true);
        return bitmapC;
    }

    private int o() {
        int iP = p();
        if (iP <= 0) {
            return iP;
        }
        ByteBuffer byteBuffer = this.f33103d;
        byteBuffer.get(this.f33104e, 0, Math.min(iP, byteBuffer.remaining()));
        return iP;
    }

    private int p() {
        return this.f33103d.get() & 255;
    }

    private Bitmap r(b bVar, b bVar2) {
        int i10;
        int i11;
        Bitmap bitmap;
        int[] iArr = this.f33109j;
        int i12 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f33112m;
            if (bitmap2 != null) {
                this.f33102c.a(bitmap2);
            }
            this.f33112m = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f33077g == 3 && this.f33112m == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i11 = bVar2.f33077g) > 0) {
            if (i11 == 2) {
                if (!bVar.f33076f) {
                    c cVar = this.f33111l;
                    int i13 = cVar.f33093l;
                    if (bVar.f33081k == null || cVar.f33091j != bVar.f33078h) {
                        i12 = i13;
                    }
                }
                int i14 = bVar2.f33074d;
                int i15 = this.f33115p;
                int i16 = i14 / i15;
                int i17 = bVar2.f33072b / i15;
                int i18 = bVar2.f33073c / i15;
                int i19 = bVar2.f33071a / i15;
                int i20 = this.f33117r;
                int i21 = (i17 * i20) + i19;
                int i22 = (i16 * i20) + i21;
                while (i21 < i22) {
                    int i23 = i21 + i18;
                    for (int i24 = i21; i24 < i23; i24++) {
                        iArr[i24] = i12;
                    }
                    i21 += this.f33117r;
                }
            } else if (i11 == 3 && (bitmap = this.f33112m) != null) {
                int i25 = this.f33117r;
                bitmap.getPixels(iArr, 0, i25, 0, 0, i25, this.f33116q);
            }
        }
        l(bVar);
        if (bVar.f33075e || this.f33115p != 1) {
            j(bVar);
        } else {
            k(bVar);
        }
        if (this.f33113n && ((i10 = bVar.f33077g) == 0 || i10 == 1)) {
            if (this.f33112m == null) {
                this.f33112m = n();
            }
            Bitmap bitmap3 = this.f33112m;
            int i26 = this.f33117r;
            bitmap3.setPixels(iArr, 0, i26, 0, 0, i26, this.f33116q);
        }
        Bitmap bitmapN = n();
        int i27 = this.f33117r;
        bitmapN.setPixels(iArr, 0, i27, 0, 0, i27, this.f33116q);
        return bitmapN;
    }

    @Override // q0.a
    @Nullable
    public synchronized Bitmap a() {
        if (this.f33111l.f33084c <= 0 || this.f33110k < 0) {
            String str = f33099u;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.f33111l.f33084c + ", framePointer=" + this.f33110k);
            }
            this.f33114o = 1;
        }
        int i10 = this.f33114o;
        if (i10 != 1 && i10 != 2) {
            this.f33114o = 0;
            if (this.f33104e == null) {
                this.f33104e = this.f33102c.b(255);
            }
            b bVar = this.f33111l.f33086e.get(this.f33110k);
            int i11 = this.f33110k - 1;
            b bVar2 = i11 >= 0 ? this.f33111l.f33086e.get(i11) : null;
            int[] iArr = bVar.f33081k;
            if (iArr == null) {
                iArr = this.f33111l.f33082a;
            }
            this.f33100a = iArr;
            if (iArr == null) {
                String str2 = f33099u;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No valid color table found for frame #" + this.f33110k);
                }
                this.f33114o = 1;
                return null;
            }
            if (bVar.f33076f) {
                System.arraycopy(iArr, 0, this.f33101b, 0, iArr.length);
                int[] iArr2 = this.f33101b;
                this.f33100a = iArr2;
                iArr2[bVar.f33078h] = 0;
                if (bVar.f33077g == 2 && this.f33110k == 0) {
                    this.f33118s = Boolean.TRUE;
                }
            }
            return r(bVar, bVar2);
        }
        String str3 = f33099u;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.f33114o);
        }
        return null;
    }

    @Override // q0.a
    public void b() {
        this.f33110k = (this.f33110k + 1) % this.f33111l.f33084c;
    }

    @Override // q0.a
    public int c() {
        return this.f33111l.f33084c;
    }

    @Override // q0.a
    public void clear() {
        this.f33111l = null;
        byte[] bArr = this.f33108i;
        if (bArr != null) {
            this.f33102c.e(bArr);
        }
        int[] iArr = this.f33109j;
        if (iArr != null) {
            this.f33102c.f(iArr);
        }
        Bitmap bitmap = this.f33112m;
        if (bitmap != null) {
            this.f33102c.a(bitmap);
        }
        this.f33112m = null;
        this.f33103d = null;
        this.f33118s = null;
        byte[] bArr2 = this.f33104e;
        if (bArr2 != null) {
            this.f33102c.e(bArr2);
        }
    }

    @Override // q0.a
    public void d(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.f33119t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    @Override // q0.a
    public int e() {
        int i10;
        if (this.f33111l.f33084c <= 0 || (i10 = this.f33110k) < 0) {
            return 0;
        }
        return m(i10);
    }

    @Override // q0.a
    public void f() {
        this.f33110k = -1;
    }

    @Override // q0.a
    public int g() {
        return this.f33110k;
    }

    @Override // q0.a
    @NonNull
    public ByteBuffer getData() {
        return this.f33103d;
    }

    @Override // q0.a
    public int h() {
        return this.f33103d.limit() + this.f33108i.length + (this.f33109j.length * 4);
    }

    public int m(int i10) {
        if (i10 >= 0) {
            c cVar = this.f33111l;
            if (i10 < cVar.f33084c) {
                return cVar.f33086e.get(i10).f33079i;
            }
        }
        return -1;
    }

    public synchronized void q(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
        }
        int iHighestOneBit = Integer.highestOneBit(i10);
        this.f33114o = 0;
        this.f33111l = cVar;
        this.f33110k = -1;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f33103d = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f33103d.order(ByteOrder.LITTLE_ENDIAN);
        this.f33113n = false;
        Iterator<b> it = cVar.f33086e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().f33077g == 3) {
                this.f33113n = true;
                break;
            }
        }
        this.f33115p = iHighestOneBit;
        int i11 = cVar.f33087f;
        this.f33117r = i11 / iHighestOneBit;
        int i12 = cVar.f33088g;
        this.f33116q = i12 / iHighestOneBit;
        this.f33108i = this.f33102c.b(i11 * i12);
        this.f33109j = this.f33102c.d(this.f33117r * this.f33116q);
    }

    public e(@NonNull a.InterfaceC0656a interfaceC0656a) {
        this.f33101b = new int[256];
        this.f33119t = Bitmap.Config.ARGB_8888;
        this.f33102c = interfaceC0656a;
        this.f33111l = new c();
    }
}
