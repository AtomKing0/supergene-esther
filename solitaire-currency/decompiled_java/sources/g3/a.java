package g3;

import androidx.annotation.Nullable;
import c3.h;
import e5.e;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: IcyDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f25868c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharsetDecoder f25869a = e.f25140c.newDecoder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharsetDecoder f25870b = e.f25139b.newDecoder();

    @Nullable
    private String c(ByteBuffer byteBuffer) {
        try {
            return this.f25869a.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String string = this.f25870b.decode(byteBuffer).toString();
                this.f25870b.reset();
                byteBuffer.rewind();
                return string;
            } catch (CharacterCodingException unused2) {
                this.f25870b.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.f25870b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            this.f25869a.reset();
            byteBuffer.rewind();
        }
    }

    @Override // c3.h
    protected c3.a b(c3.e eVar, ByteBuffer byteBuffer) {
        String strC = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (strC == null) {
            return new c3.a(new c(bArr, null, null));
        }
        Matcher matcher = f25868c.matcher(strC);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                String strE = e5.c.e(strGroup);
                strE.hashCode();
                if (strE.equals("streamurl")) {
                    str2 = strGroup2;
                } else if (strE.equals("streamtitle")) {
                    str = strGroup2;
                }
            }
        }
        return new c3.a(new c(bArr, str, str2));
    }
}
