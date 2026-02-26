package o2;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import l2.t1;
import o2.g0;
import o2.m;

/* JADX INFO: compiled from: FrameworkMediaDrm.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(18)
public final class k0 implements g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g0.c f31902d = new g0.c() { // from class: o2.i0
        @Override // o2.g0.c
        public final g0 acquireExoMediaDrm(UUID uuid) {
            return k0.p(uuid);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UUID f31903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaDrm f31904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f31905c;

    /* JADX INFO: compiled from: FrameworkMediaDrm.java */
    @RequiresApi(31)
    private static class a {
        @DoNotInline
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }

        @DoNotInline
        public static void b(MediaDrm mediaDrm, byte[] bArr, t1 t1Var) {
            LogSessionId logSessionIdA = t1Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            ((MediaDrm.PlaybackComponent) a4.a.e(mediaDrm.getPlaybackComponent(bArr))).setLogSessionId(logSessionIdA);
        }
    }

    private k0(UUID uuid) throws UnsupportedSchemeException {
        a4.a.e(uuid);
        a4.a.b(!k2.i.f29127b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f31903a = uuid;
        MediaDrm mediaDrm = new MediaDrm(j(uuid));
        this.f31904b = mediaDrm;
        this.f31905c = 1;
        if (k2.i.f29129d.equals(uuid) && q()) {
            l(mediaDrm);
        }
    }

    private static byte[] e(byte[] bArr) {
        a4.c0 c0Var = new a4.c0(bArr);
        int iQ = c0Var.q();
        short s10 = c0Var.s();
        short s11 = c0Var.s();
        if (s10 != 1 || s11 != 1) {
            a4.t.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short s12 = c0Var.s();
        Charset charset = e5.e.f25142e;
        String strB = c0Var.B(s12, charset);
        if (strB.contains("<LA_URL>")) {
            return bArr;
        }
        int iIndexOf = strB.indexOf("</DATA>");
        if (iIndexOf == -1) {
            a4.t.i("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = strB.substring(0, iIndexOf) + "<LA_URL>https://x</LA_URL>" + strB.substring(iIndexOf);
        int i10 = iQ + 52;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i10);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(i10);
        byteBufferAllocate.putShort(s10);
        byteBufferAllocate.putShort(s11);
        byteBufferAllocate.putShort((short) (str.length() * 2));
        byteBufferAllocate.put(str.getBytes(charset));
        return byteBufferAllocate.array();
    }

    private static String f(String str) {
        return "<LA_URL>https://x</LA_URL>".equals(str) ? "" : (a4.o0.f214a == 33 && "https://default.url".equals(str)) ? "" : str;
    }

    private static byte[] g(UUID uuid, byte[] bArr) {
        return k2.i.f29128c.equals(uuid) ? o2.a.a(bArr) : bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] h(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = k2.i.f29130e
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L18
            byte[] r1 = x2.l.e(r4, r3)
            if (r1 != 0) goto Lf
            goto L10
        Lf:
            r4 = r1
        L10:
            byte[] r4 = e(r4)
            byte[] r4 = x2.l.a(r0, r4)
        L18:
            int r1 = a4.o0.f214a
            r2 = 23
            if (r1 >= r2) goto L26
            java.util.UUID r1 = k2.i.f29129d
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L58
        L26:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5f
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = a4.o0.f216c
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L5f
            java.lang.String r0 = a4.o0.f217d
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
        L58:
            byte[] r3 = x2.l.e(r4, r3)
            if (r3 == 0) goto L5f
            return r3
        L5f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.k0.h(java.util.UUID, byte[]):byte[]");
    }

    private static String i(UUID uuid, String str) {
        return (a4.o0.f214a < 26 && k2.i.f29128c.equals(uuid) && (MimeTypes.VIDEO_MP4.equals(str) || MimeTypes.AUDIO_MP4.equals(str))) ? C.CENC_TYPE_cenc : str;
    }

    private static UUID j(UUID uuid) {
        return (a4.o0.f214a >= 27 || !k2.i.f29128c.equals(uuid)) ? uuid : k2.i.f29127b;
    }

    private static void l(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static m.b n(UUID uuid, List<m.b> list) {
        boolean z10;
        if (!k2.i.f29129d.equals(uuid)) {
            return list.get(0);
        }
        if (a4.o0.f214a >= 28 && list.size() > 1) {
            m.b bVar = list.get(0);
            int length = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                m.b bVar2 = list.get(i10);
                byte[] bArr = (byte[]) a4.a.e(bVar2.f31923e);
                if (!a4.o0.c(bVar2.f31922d, bVar.f31922d) || !a4.o0.c(bVar2.f31921c, bVar.f31921c) || !x2.l.c(bArr)) {
                    z10 = false;
                    break;
                }
                length += bArr.length;
            }
            z10 = true;
            if (z10) {
                byte[] bArr2 = new byte[length];
                int i11 = 0;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    byte[] bArr3 = (byte[]) a4.a.e(list.get(i12).f31923e);
                    int length2 = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i11, length2);
                    i11 += length2;
                }
                return bVar.a(bArr2);
            }
        }
        for (int i13 = 0; i13 < list.size(); i13++) {
            m.b bVar3 = list.get(i13);
            int iG = x2.l.g((byte[]) a4.a.e(bVar3.f31923e));
            int i14 = a4.o0.f214a;
            if (i14 < 23 && iG == 0) {
                return bVar3;
            }
            if (i14 >= 23 && iG == 1) {
                return bVar3;
            }
        }
        return list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(g0.b bVar, MediaDrm mediaDrm, byte[] bArr, int i10, int i11, byte[] bArr2) {
        bVar.a(this, bArr, i10, i11, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g0 p(UUID uuid) {
        try {
            return r(uuid);
        } catch (p0 unused) {
            a4.t.c("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new d0();
        }
    }

    private static boolean q() {
        return "ASUS_Z00AD".equals(a4.o0.f217d);
    }

    public static k0 r(UUID uuid) throws p0 {
        try {
            return new k0(uuid);
        } catch (UnsupportedSchemeException e10) {
            throw new p0(1, e10);
        } catch (Exception e11) {
            throw new p0(2, e11);
        }
    }

    @Override // o2.g0
    public void a(@Nullable final g0.b bVar) {
        this.f31904b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: o2.j0
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i10, int i11, byte[] bArr2) {
                this.f31899a.o(bVar, mediaDrm, bArr, i10, i11, bArr2);
            }
        });
    }

    @Override // o2.g0
    public void b(byte[] bArr, t1 t1Var) {
        if (a4.o0.f214a >= 31) {
            try {
                a.b(this.f31904b, bArr, t1Var);
            } catch (UnsupportedOperationException unused) {
                a4.t.i("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // o2.g0
    public void closeSession(byte[] bArr) {
        this.f31904b.closeSession(bArr);
    }

    @Override // o2.g0
    public int getCryptoType() {
        return 2;
    }

    @Override // o2.g0
    @SuppressLint({"WrongConstant"})
    public g0.a getKeyRequest(byte[] bArr, @Nullable List<m.b> list, int i10, @Nullable HashMap<String, String> map) throws NotProvisionedException {
        m.b bVarN;
        byte[] bArrH;
        String strI;
        if (list != null) {
            bVarN = n(this.f31903a, list);
            bArrH = h(this.f31903a, (byte[]) a4.a.e(bVarN.f31923e));
            strI = i(this.f31903a, bVarN.f31922d);
        } else {
            bVarN = null;
            bArrH = null;
            strI = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f31904b.getKeyRequest(bArr, bArrH, strI, i10, map);
        byte[] bArrG = g(this.f31903a, keyRequest.getData());
        String strF = f(keyRequest.getDefaultUrl());
        if (TextUtils.isEmpty(strF) && bVarN != null && !TextUtils.isEmpty(bVarN.f31921c)) {
            strF = bVarN.f31921c;
        }
        return new g0.a(bArrG, strF, a4.o0.f214a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // o2.g0
    public g0.d getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.f31904b.getProvisionRequest();
        return new g0.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // o2.g0
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public h0 createCryptoConfig(byte[] bArr) throws MediaCryptoException {
        return new h0(j(this.f31903a), bArr, a4.o0.f214a < 21 && k2.i.f29129d.equals(this.f31903a) && "L3".equals(m("securityLevel")));
    }

    public String m(String str) {
        return this.f31904b.getPropertyString(str);
    }

    @Override // o2.g0
    public byte[] openSession() throws MediaDrmException {
        return this.f31904b.openSession();
    }

    @Override // o2.g0
    @Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        if (k2.i.f29128c.equals(this.f31903a)) {
            bArr2 = o2.a.b(bArr2);
        }
        return this.f31904b.provideKeyResponse(bArr, bArr2);
    }

    @Override // o2.g0
    public void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        this.f31904b.provideProvisionResponse(bArr);
    }

    @Override // o2.g0
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        return this.f31904b.queryKeyStatus(bArr);
    }

    @Override // o2.g0
    public synchronized void release() {
        int i10 = this.f31905c - 1;
        this.f31905c = i10;
        if (i10 == 0) {
            this.f31904b.release();
        }
    }

    @Override // o2.g0
    public boolean requiresSecureDecoder(byte[] bArr, String str) {
        if (a4.o0.f214a >= 31) {
            return a.a(this.f31904b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f31903a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // o2.g0
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.f31904b.restoreKeys(bArr, bArr2);
    }
}
