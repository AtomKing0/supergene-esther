package x2;

import a4.c0;
import a4.t;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import c3.a;
import com.unity3d.services.UnityAdsConstants;
import k2.o1;
import p2.x;

/* JADX INFO: compiled from: MetadataUtil.java */
/* JADX INFO: loaded from: classes2.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    static final String[] f35815a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    @Nullable
    private static h3.e a(int i10, c0 c0Var) {
        int iN = c0Var.n();
        if (c0Var.n() == 1684108385) {
            c0Var.Q(8);
            String strY = c0Var.y(iN - 16);
            return new h3.e(C.LANGUAGE_UNDETERMINED, strY, strY);
        }
        t.i("MetadataUtil", "Failed to parse comment attribute: " + a.a(i10));
        return null;
    }

    @Nullable
    private static h3.a b(c0 c0Var) {
        int iN = c0Var.n();
        if (c0Var.n() != 1684108385) {
            t.i("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int iB = a.b(c0Var.n());
        String str = iB == 13 ? MimeTypes.IMAGE_JPEG : iB == 14 ? MimeTypes.IMAGE_PNG : null;
        if (str == null) {
            t.i("MetadataUtil", "Unrecognized cover art flags: " + iB);
            return null;
        }
        c0Var.Q(4);
        int i10 = iN - 16;
        byte[] bArr = new byte[i10];
        c0Var.j(bArr, 0, i10);
        return new h3.a(str, null, 3, bArr);
    }

    @Nullable
    public static a.b c(c0 c0Var) {
        int iE = c0Var.e() + c0Var.n();
        int iN = c0Var.n();
        int i10 = (iN >> 24) & 255;
        try {
            if (i10 == 169 || i10 == 253) {
                int i11 = 16777215 & iN;
                if (i11 == 6516084) {
                    return a(iN, c0Var);
                }
                if (i11 == 7233901 || i11 == 7631467) {
                    return h(iN, "TIT2", c0Var);
                }
                if (i11 == 6516589 || i11 == 7828084) {
                    return h(iN, "TCOM", c0Var);
                }
                if (i11 == 6578553) {
                    return h(iN, "TDRC", c0Var);
                }
                if (i11 == 4280916) {
                    return h(iN, "TPE1", c0Var);
                }
                if (i11 == 7630703) {
                    return h(iN, "TSSE", c0Var);
                }
                if (i11 == 6384738) {
                    return h(iN, "TALB", c0Var);
                }
                if (i11 == 7108978) {
                    return h(iN, "USLT", c0Var);
                }
                if (i11 == 6776174) {
                    return h(iN, "TCON", c0Var);
                }
                if (i11 == 6779504) {
                    return h(iN, "TIT1", c0Var);
                }
            } else {
                if (iN == 1735291493) {
                    return g(c0Var);
                }
                if (iN == 1684632427) {
                    return d(iN, "TPOS", c0Var);
                }
                if (iN == 1953655662) {
                    return d(iN, "TRCK", c0Var);
                }
                if (iN == 1953329263) {
                    return i(iN, "TBPM", c0Var, true, false);
                }
                if (iN == 1668311404) {
                    return i(iN, "TCMP", c0Var, true, true);
                }
                if (iN == 1668249202) {
                    return b(c0Var);
                }
                if (iN == 1631670868) {
                    return h(iN, "TPE2", c0Var);
                }
                if (iN == 1936682605) {
                    return h(iN, "TSOT", c0Var);
                }
                if (iN == 1936679276) {
                    return h(iN, "TSO2", c0Var);
                }
                if (iN == 1936679282) {
                    return h(iN, "TSOA", c0Var);
                }
                if (iN == 1936679265) {
                    return h(iN, "TSOP", c0Var);
                }
                if (iN == 1936679791) {
                    return h(iN, "TSOC", c0Var);
                }
                if (iN == 1920233063) {
                    return i(iN, "ITUNESADVISORY", c0Var, false, false);
                }
                if (iN == 1885823344) {
                    return i(iN, "ITUNESGAPLESS", c0Var, false, true);
                }
                if (iN == 1936683886) {
                    return h(iN, "TVSHOWSORT", c0Var);
                }
                if (iN == 1953919848) {
                    return h(iN, "TVSHOW", c0Var);
                }
                if (iN == 757935405) {
                    return e(c0Var, iE);
                }
            }
            t.b("MetadataUtil", "Skipped unknown metadata entry: " + a.a(iN));
            c0Var.P(iE);
            return null;
        } finally {
            c0Var.P(iE);
        }
    }

    @Nullable
    private static h3.m d(int i10, String str, c0 c0Var) {
        int iN = c0Var.n();
        if (c0Var.n() == 1684108385 && iN >= 22) {
            c0Var.Q(10);
            int iJ = c0Var.J();
            if (iJ > 0) {
                String str2 = "" + iJ;
                int iJ2 = c0Var.J();
                if (iJ2 > 0) {
                    str2 = str2 + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH + iJ2;
                }
                return new h3.m(str, null, str2);
            }
        }
        t.i("MetadataUtil", "Failed to parse index/count attribute: " + a.a(i10));
        return null;
    }

    @Nullable
    private static h3.i e(c0 c0Var, int i10) {
        String strY = null;
        String strY2 = null;
        int i11 = -1;
        int i12 = -1;
        while (c0Var.e() < i10) {
            int iE = c0Var.e();
            int iN = c0Var.n();
            int iN2 = c0Var.n();
            c0Var.Q(4);
            if (iN2 == 1835360622) {
                strY = c0Var.y(iN - 12);
            } else if (iN2 == 1851878757) {
                strY2 = c0Var.y(iN - 12);
            } else {
                if (iN2 == 1684108385) {
                    i11 = iE;
                    i12 = iN;
                }
                c0Var.Q(iN - 12);
            }
        }
        if (strY == null || strY2 == null || i11 == -1) {
            return null;
        }
        c0Var.P(i11);
        c0Var.Q(16);
        return new h3.j(strY, strY2, c0Var.y(i12 - 16));
    }

    @Nullable
    public static i3.a f(c0 c0Var, int i10, String str) {
        while (true) {
            int iE = c0Var.e();
            if (iE >= i10) {
                return null;
            }
            int iN = c0Var.n();
            if (c0Var.n() == 1684108385) {
                int iN2 = c0Var.n();
                int iN3 = c0Var.n();
                int i11 = iN - 16;
                byte[] bArr = new byte[i11];
                c0Var.j(bArr, 0, i11);
                return new i3.a(str, bArr, iN3, iN2);
            }
            c0Var.P(iE + iN);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static h3.m g(a4.c0 r3) {
        /*
            int r3 = j(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = x2.h.f35815a
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L1c
            h3.m r1 = new h3.m
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L1c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            a4.t.i(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.h.g(a4.c0):h3.m");
    }

    @Nullable
    private static h3.m h(int i10, String str, c0 c0Var) {
        int iN = c0Var.n();
        if (c0Var.n() == 1684108385) {
            c0Var.Q(8);
            return new h3.m(str, null, c0Var.y(iN - 16));
        }
        t.i("MetadataUtil", "Failed to parse text attribute: " + a.a(i10));
        return null;
    }

    @Nullable
    private static h3.i i(int i10, String str, c0 c0Var, boolean z10, boolean z11) {
        int iJ = j(c0Var);
        if (z11) {
            iJ = Math.min(1, iJ);
        }
        if (iJ >= 0) {
            return z10 ? new h3.m(str, null, Integer.toString(iJ)) : new h3.e(C.LANGUAGE_UNDETERMINED, str, Integer.toString(iJ));
        }
        t.i("MetadataUtil", "Failed to parse uint8 attribute: " + a.a(i10));
        return null;
    }

    private static int j(c0 c0Var) {
        c0Var.Q(4);
        if (c0Var.n() == 1684108385) {
            c0Var.Q(8);
            return c0Var.D();
        }
        t.i("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i10, x xVar, o1.b bVar) {
        if (i10 == 1 && xVar.a()) {
            bVar.N(xVar.f32548a).O(xVar.f32549b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void l(int r5, @androidx.annotation.Nullable c3.a r6, @androidx.annotation.Nullable c3.a r7, k2.o1.b r8, c3.a... r9) {
        /*
            c3.a r0 = new c3.a
            r1 = 0
            c3.a$b[] r2 = new c3.a.b[r1]
            r0.<init>(r2)
            r2 = 1
            if (r5 != r2) goto Le
            if (r6 == 0) goto L3c
            goto L3d
        Le:
            r6 = 2
            if (r5 != r6) goto L3c
            if (r7 == 0) goto L3c
            r5 = r1
        L14:
            int r6 = r7.e()
            if (r5 >= r6) goto L3c
            c3.a$b r6 = r7.d(r5)
            boolean r3 = r6 instanceof i3.a
            if (r3 == 0) goto L39
            i3.a r6 = (i3.a) r6
            java.lang.String r3 = r6.f26570a
            java.lang.String r4 = "com.android.capture.fps"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L39
            c3.a r5 = new c3.a
            c3.a$b[] r7 = new c3.a.b[r2]
            r7[r1] = r6
            r5.<init>(r7)
            r6 = r5
            goto L3d
        L39:
            int r5 = r5 + 1
            goto L14
        L3c:
            r6 = r0
        L3d:
            int r5 = r9.length
        L3e:
            if (r1 >= r5) goto L49
            r7 = r9[r1]
            c3.a r6 = r6.b(r7)
            int r1 = r1 + 1
            goto L3e
        L49:
            int r5 = r6.e()
            if (r5 <= 0) goto L52
            r8.X(r6)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.h.l(int, c3.a, c3.a, k2.o1$b, c3.a[]):void");
    }
}
