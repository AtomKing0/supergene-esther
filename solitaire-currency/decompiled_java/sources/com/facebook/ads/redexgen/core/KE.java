package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KE extends AbstractC2192aB implements View.OnClickListener {
    public static byte[] A0D;
    public static String[] A0E = {"zJy5N3L509NIqOAGCBmq2SY7W4xK8HwT", "H2", ExifInterface.LONGITUDE_EAST, "vMyDxD7xbIgTd", "0bWjMiKAxESivC84rSJqWsF4vTTr4zpm", "NIsgbM1VoVKu1UXdUm6ipB03AExBFzGo", "hF", "2iAtRdiONhZPMieR3MSLVzPYox5YjbDW"};
    public static final int A0F;
    public int A00;
    public int A01;
    public Bitmap A02;
    public Paint A03;
    public Rect A04;
    public C2387dL A05;
    public C2084Wd A06;
    public KG A07;
    public String A08;
    public String A09;
    public boolean A0A;
    public final a5 A0B;
    public final Map<String, String> A0C;

    public static String A01(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 121);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0D = new byte[]{-30, -21, -24, -30, -22, -34, -14, -18, -12, -15, -30, -28, -23, -27, -80, -16, -24, -10, -10, -24, -15, -22, -24, -11, 40, 38, 24, 37, 22, 31, 28, 22, 30};
    }

    static {
        A04();
        A0F = (int) (AbstractC2090Wl.A02 * 24.0f);
    }

    public KE(C2387dL c2387dL, AbstractC2662hy abstractC2662hy, C1850My c1850My, US us, InterfaceC2118Xn interfaceC2118Xn, C2460eX c2460eX, XH xh, InterfaceC2100Wv interfaceC2100Wv) {
        this(c2387dL, abstractC2662hy.A0r(), c1850My, abstractC2662hy.A20().A0J().A06(), us, interfaceC2118Xn, c2460eX, xh, abstractC2662hy.A21(), interfaceC2100Wv);
        this.A0B.A08(abstractC2662hy);
    }

    public KE(C2387dL c2387dL, String str, C1850My c1850My, US us, InterfaceC2118Xn interfaceC2118Xn, C2460eX c2460eX, XH xh, N3 n32) {
        this(c2387dL, str, c1850My, false, us, interfaceC2118Xn, c2460eX, xh, n32);
    }

    public KE(C2387dL c2387dL, String str, C1850My c1850My, boolean z10, US us, InterfaceC2118Xn interfaceC2118Xn, C2460eX c2460eX, XH xh, N3 n32) {
        super(c2387dL, c1850My);
        this.A0C = new HashMap();
        this.A05 = c2387dL;
        this.A0A = z10;
        this.A0B = new a5(c2387dL, str, c2460eX, xh, us, n32, interfaceC2118Xn);
        setOnClickListener(this);
        XP.A0E(1001, this);
    }

    public KE(C2387dL c2387dL, String str, C1850My c1850My, boolean z10, US us, InterfaceC2118Xn interfaceC2118Xn, C2460eX c2460eX, XH xh, N3 n32, InterfaceC2100Wv interfaceC2100Wv) {
        super(c2387dL, c1850My);
        this.A0C = new HashMap();
        this.A05 = c2387dL;
        this.A0A = z10;
        this.A0B = new a5(c2387dL, str, c2460eX, xh, us, n32, interfaceC2118Xn, interfaceC2100Wv);
        setOnClickListener(this);
        XP.A0E(1001, this);
    }

    public static Bitmap A00(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void A02() {
        if (this.A0A && this.A09 != null) {
            this.A02 = A00(XY.A03(this.A05, this.A09.contains(A01(12, 12, 10)) ? XX.MESSENGER : XX.WHATSAPP));
            this.A03 = new Paint();
            setPadding(A0F, 0, A0F, 0);
        }
    }

    private void A03() {
        if (this.A06 != null) {
            C2084Wd c2084Wd = this.A06;
            if (A0E[0].charAt(27) != 'K') {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[6] = "Jn";
            strArr[1] = "nM";
            c2084Wd.A06();
        }
        if (this.A07 != null) {
            this.A07.A04();
        }
    }

    public static boolean A05(AbstractC2662hy abstractC2662hy) {
        return ((long) abstractC2662hy.A1w()) > 0 && abstractC2662hy.A1u() >= 0;
    }

    public final ME A0E(String str) {
        if (TextUtils.isEmpty(this.A08) || TextUtils.isEmpty(this.A09)) {
            return ME.A09;
        }
        A03();
        this.A0C.put(A01(0, 12, 6), str);
        return this.A0B.A05(this.A08, this.A09, this.A0C);
    }

    public final boolean A0F(AbstractC2662hy abstractC2662hy, AbstractC2117Xm abstractC2117Xm) {
        if (this.A06 != null || !A05(abstractC2662hy) || abstractC2662hy.A24().A01() == null || abstractC2662hy.A24().A00() == null) {
            return false;
        }
        this.A07 = new KG(abstractC2662hy.A1u(), abstractC2662hy.A1w(), abstractC2662hy.A1v(), abstractC2662hy.A24().A01(), abstractC2662hy.A24().A00(), abstractC2117Xm, this);
        this.A06 = new C2084Wd(abstractC2662hy.A1w(), this.A07);
        this.A06.A07();
        return true;
    }

    public a5 getCtaActionHelper() {
        return this.A0B;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            A0E(A01(24, 9, 58));
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A03();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.A02 != null) {
            this.A04 = new Rect(0, 0, this.A02.getWidth(), this.A02.getHeight());
            this.A01 = this.A02.getWidth();
            this.A00 = 12;
            int shift = (this.A01 + this.A00) / 2;
            canvas.save();
            canvas.translate(shift, 0.0f);
        }
        super.onDraw(canvas);
        if (this.A02 != null) {
            float width = (getWidth() / 2.0f) - ((getPaint().measureText((String) getText()) + 10.0f) / 2.0f);
            float textWidth = this.A01;
            float f10 = width - textWidth;
            float textWidth2 = this.A00;
            int i10 = (int) (f10 - textWidth2);
            int top = (getHeight() / 2) - (this.A01 / 2);
            int left = this.A01;
            Rect destRect = new Rect(i10, top, left + i10, this.A01 + top);
            canvas.drawBitmap(this.A02, this.A04, destRect, this.A03);
            canvas.restore();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (i10 != 0) {
            A03();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (!z10) {
            A03();
        }
    }

    public void setCreativeAsCtaLoggingHelper(C2086Wh c2086Wh) {
        this.A0B.A09(c2086Wh);
    }

    public void setCta(C1851Mz c1851Mz, String str, Map<String, String> extraData) {
        setCta(c1851Mz, str, extraData, null);
    }

    public void setCta(C1851Mz c1851Mz, String str, Map<String, String> extraData, InterfaceC2100Wv interfaceC2100Wv, InterfaceC2187a4 interfaceC2187a4) {
        setCta(c1851Mz, str, extraData, interfaceC2187a4);
        this.A0B.A0A(interfaceC2100Wv);
    }

    public void setCta(C1851Mz c1851Mz, String str, Map<String, String> extraData, InterfaceC2187a4 interfaceC2187a4) {
        this.A08 = str;
        this.A09 = c1851Mz.A05();
        this.A0C.putAll(extraData);
        this.A0B.A0B(interfaceC2187a4);
        String strA04 = c1851Mz.A04();
        if (!TextUtils.isEmpty(strA04)) {
            String buttonText = this.A09;
            if (!TextUtils.isEmpty(buttonText)) {
                setText(strA04);
                A02();
                return;
            }
        }
        setVisibility(8);
    }

    public void setIsInAppBrowser(boolean z10) {
        this.A0B.A0C(z10);
    }
}
