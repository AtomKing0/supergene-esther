package com.moloco.sdk.internal.services.encryption;

import android.util.Base64;
import com.moloco.sdk.BuildConfig;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import p9.q;
import v8.l;
import v8.n;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.moloco.sdk.internal.services.encryption.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final l f18633b = n.a(c.f18641g);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final l f18634c = n.a(d.f18642g);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final l f18635d = n.a(a.f18639g);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final l f18636e = n.a(C0329b.f18640g);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final SecretKeySpec f18637f = f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final l f18638g = n.a(e.f18643g);

    public static final class a extends v implements h9.a<String> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f18639g = new a();

        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return q.t(new byte[]{65, 69, 83});
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.encryption.b$b, reason: collision with other inner class name */
    public static final class C0329b extends v implements h9.a<String> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final C0329b f18640g = new C0329b();

        public C0329b() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            byte[] bArrDecode = Base64.decode(new byte[]{81, 85, 86, 84, 76, 48, 100, 68, 84, 83, 57, 79, 98, 49, 66, 104, 90, 71, 82, 112, 98, 109, 99, 61}, 0);
            t.h(bArrDecode, "decode(byteArrayOf(81, 8… 99, 61), Base64.DEFAULT)");
            return q.t(bArrDecode);
        }
    }

    public static final class c extends v implements h9.a<String> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f18641g = new c();

        public c() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            byte[] bArrDecode = Base64.decode(new byte[]{85, 108, 78, 66}, 0);
            t.h(bArrDecode, "decode(byteArrayOf(85, 1… 78, 66), Base64.DEFAULT)");
            return q.t(bArrDecode);
        }
    }

    public static final class d extends v implements h9.a<String> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f18642g = new d();

        public d() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return q.t(new byte[]{82, 83, 65, 47, 69, 67, 66, 47, 79, 65, 69, 80, 87, 105, 116, 104, 83, 72, 65, 45, 50, 53, 54, 65, 110, 100, 77, 71, 70, 49, 80, 97, 100, 100, 105, 110, 103});
        }
    }

    public static final class e extends v implements h9.a<IvParameterSpec> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f18643g = new e();

        public e() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final IvParameterSpec invoke() {
            return new IvParameterSpec(Base64.decode(BuildConfig.MOLOCO_SDK_BIDTOKEN_SALT, 0));
        }
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    @NotNull
    public byte[] a(@NotNull byte[] data) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        t.i(data, "data");
        Cipher cipher = Cipher.getInstance(h());
        cipher.init(1, c(), b());
        byte[] bArrDoFinal = cipher.doFinal(data);
        t.h(bArrDoFinal, "cipher.doFinal(data)");
        return bArrDoFinal;
    }

    @NotNull
    public IvParameterSpec b() {
        return (IvParameterSpec) this.f18638g.getValue();
    }

    @NotNull
    public SecretKeySpec c() {
        return this.f18637f;
    }

    @NotNull
    public byte[] d(@NotNull byte[] input, @NotNull String publicKey) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        t.i(input, "input");
        t.i(publicKey, "publicKey");
        Cipher cipher = Cipher.getInstance(j());
        cipher.init(1, e(publicKey));
        byte[] bArrDoFinal = cipher.doFinal(c().getEncoded());
        t.h(bArrDoFinal, "cipher.doFinal(aesSecret.encoded)");
        return bArrDoFinal;
    }

    public final PublicKey e(String str) throws InvalidKeySpecException {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(i()).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        t.h(publicKeyGeneratePublic, "keyFactory.generatePublic(keySpec)");
        return publicKeyGeneratePublic;
    }

    public final SecretKeySpec f() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(g());
        keyGenerator.init(256);
        return new SecretKeySpec(keyGenerator.generateKey().getEncoded(), g());
    }

    public final String g() {
        return (String) this.f18635d.getValue();
    }

    public final String h() {
        return (String) this.f18636e.getValue();
    }

    public final String i() {
        return (String) this.f18633b.getValue();
    }

    public final String j() {
        return (String) this.f18634c.getValue();
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    @NotNull
    public byte[] a(@NotNull String rsaPublicKey) {
        t.i(rsaPublicKey, "rsaPublicKey");
        byte[] encoded = c().getEncoded();
        t.h(encoded, "aesSecret.encoded");
        return d(encoded, rsaPublicKey);
    }
}
