package p2;

import a4.o0;
import c3.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: GaplessInfoHolder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f32547c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32548a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f32549b = -1;

    private boolean b(String str) {
        Matcher matcher = f32547c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int i10 = Integer.parseInt((String) o0.j(matcher.group(1)), 16);
            int i11 = Integer.parseInt((String) o0.j(matcher.group(2)), 16);
            if (i10 <= 0 && i11 <= 0) {
                return false;
            }
            this.f32548a = i10;
            this.f32549b = i11;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.f32548a == -1 || this.f32549b == -1) ? false : true;
    }

    public boolean c(c3.a aVar) {
        for (int i10 = 0; i10 < aVar.e(); i10++) {
            a.b bVarD = aVar.d(i10);
            if (bVarD instanceof h3.e) {
                h3.e eVar = (h3.e) bVarD;
                if ("iTunSMPB".equals(eVar.f26440c) && b(eVar.f26441d)) {
                    return true;
                }
            } else if (bVarD instanceof h3.j) {
                h3.j jVar = (h3.j) bVarD;
                if ("com.apple.iTunes".equals(jVar.f26452b) && "iTunSMPB".equals(jVar.f26453c) && b(jVar.f26454d)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean d(int i10) {
        int i11 = i10 >> 12;
        int i12 = i10 & 4095;
        if (i11 <= 0 && i12 <= 0) {
            return false;
        }
        this.f32548a = i11;
        this.f32549b = i12;
        return true;
    }
}
