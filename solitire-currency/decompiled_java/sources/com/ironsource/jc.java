package com.ironsource;

import android.text.TextUtils;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
class jc implements Callable<pa> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12726d = "FileWorkerThread";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f12727e = "X-Android-Protocols";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f12728f = "http/1.1,h2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oa f12729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12731c;

    jc(oa oaVar, String str, long j10) {
        this.f12729a = oaVar;
        this.f12730b = str;
        this.f12731c = j10;
    }

    int a(byte[] bArr, String str) throws Exception {
        return IronSourceStorageUtils.saveFile(bArr, str);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public pa call() throws Throwable {
        int i10;
        if (this.f12731c == 0) {
            this.f12731c = 1L;
        }
        pa paVarA = null;
        for (int i11 = 0; i11 < this.f12731c; i11++) {
            paVarA = a(this.f12729a.e(), i11, this.f12729a.a(), this.f12729a.c(), this.f12729a.f());
            int iB = paVarA.b();
            if (iB != 1008 && iB != 1009) {
                break;
            }
        }
        if (paVarA != null && paVarA.a() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f12730b);
            String str = File.separator;
            sb.append(str);
            sb.append(this.f12729a.b().getName());
            String string = sb.toString();
            String str2 = this.f12729a.d() + str + x8.E + this.f12729a.b().getName();
            try {
                if (a(paVarA.a(), str2) == 0) {
                    paVarA.a(1006);
                } else if (!a(str2, string)) {
                    paVarA.a(1014);
                }
            } catch (FileNotFoundException e10) {
                i9.d().a(e10);
                i10 = 1018;
                paVarA.a(i10);
            } catch (Error e11) {
                i9.d().a(e11);
                if (!TextUtils.isEmpty(e11.getMessage())) {
                    Logger.i(f12726d, e11.getMessage());
                }
                i10 = 1019;
                paVarA.a(i10);
            } catch (Exception e12) {
                i9.d().a(e12);
                if (!TextUtils.isEmpty(e12.getMessage())) {
                    Logger.i(f12726d, e12.getMessage());
                }
                paVarA.a(1009);
            }
        }
        return paVarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0106 A[Catch: all -> 0x0102, PHI: r4 r8
      0x0106: PHI (r4v13 java.net.HttpURLConnection) = 
      (r4v8 java.net.HttpURLConnection)
      (r4v9 java.net.HttpURLConnection)
      (r4v10 java.net.HttpURLConnection)
      (r4v11 java.net.HttpURLConnection)
      (r4v14 java.net.HttpURLConnection)
     binds: [B:63:0x0104, B:88:0x0140, B:80:0x012d, B:96:0x0153, B:72:0x011a] A[DONT_GENERATE, DONT_INLINE]
      0x0106: PHI (r8v24 int) = (r8v14 int), (r8v17 int), (r8v19 int), (r8v21 int), (r8v27 int) binds: [B:63:0x0104, B:88:0x0140, B:80:0x012d, B:96:0x0153, B:72:0x011a] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {all -> 0x0102, blocks: (B:60:0x00fe, B:64:0x0106, B:71:0x0117, B:79:0x012a, B:87:0x013d, B:95:0x0150), top: B:112:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    com.ironsource.pa a(java.lang.String r7, int r8, int r9, int r10, boolean r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.jc.a(java.lang.String, int, int, int, boolean):com.ironsource.pa");
    }

    boolean a(String str, String str2) throws Exception {
        return IronSourceStorageUtils.renameFile(str, str2);
    }

    byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i10 = inputStream.read(bArr, 0, 8192);
            if (i10 == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i10);
        }
    }
}
