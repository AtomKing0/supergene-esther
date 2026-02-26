package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2519fV extends AbstractRunnableC2074Vt {
    public static byte[] A01;
    public static String[] A02 = {"QJHZKkwEEt2XAA8qb811yZkloXTxKqNm", "0Eo8hyAH95ZWxpQDtz3kXr2Dg2BAnbpt", "yx1IzqDtrK1i7eGrpZodHZ", "KUuZPkausU2VOaHnsIAk0Hn07pOf06lA", "ddvRVBlQrtqHFM3JEeiDXs23nPXnVLtA", "0N8fJtCAvq63STI6q3YZ9dLrj33X3xUc", "d0kigy9sFkFC2aZLzfYLsKXCuWX9Z7p3", "u6xVOdZhMjB663K3VBvQukbaw71N5v3b"};
    public final /* synthetic */ C1959Rf A00;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            int i14 = (bArrCopyOfRange[i13] ^ i12) ^ 122;
            if (A02[2].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[3] = "wsWgA7V3OPhtM2agFx6R9FkGRpDQ8hFC";
            strArr[5] = "5QDbKue07C6BH4ozhF9MSdyiVJUT25MO";
            bArrCopyOfRange[i13] = (byte) i14;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{43, 57, 57, 47, 62, 57};
    }

    static {
        A01();
    }

    public C2519fV(C1959Rf c1959Rf) {
        this.A00 = c1959Rf;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        try {
            JSONArray jSONArray = this.A00.A05.getJSONArray(A00(0, 6, 48));
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                C1957Rd assetData = C1957Rd.A00(jSONArray.getJSONObject(i10));
                this.A00.A09(assetData.A04, assetData);
            }
            this.A00.A02.A0X(new C2521fX(this), new S8(this.A00.A04, this.A00.A03));
        } catch (JSONException unused) {
            this.A00.A00.post(new C2520fW(this));
        }
    }
}
