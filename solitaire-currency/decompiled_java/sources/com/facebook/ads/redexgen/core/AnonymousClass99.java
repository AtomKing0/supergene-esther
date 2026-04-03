package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.ads.androidx.media3.extractor.ExtractorsFactory;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.99, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass99 {
    public static byte[] A08;
    public static String[] A09 = {"634gowWrnODsCbHJW3RM2adSB8UjvpNK", "SJrAWOr70TCHX", "EwIuJu9eGNp0k", "E6EVZDT", "sHeITXs", "FXQ6HdUX", "YL7g5rxYaYN1DF5ZV43is2fGGs0zV37S", "j2oNEgxbTlE4krYsb5twTfwtoUHd8Sk9"};
    public InterfaceC1568Ca A02;
    public String A05;
    public final InterfaceC13984w A06;
    public final Object A07;
    public C9U A01 = C9R.A01();
    public InterfaceC1623Ed A03 = new C2869le();
    public int A00 = 1048576;

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1754")
    public InterfaceC2740jM<InterfaceExecutorC1645Ez> A04 = new InterfaceC2740jM() { // from class: com.facebook.ads.redexgen.X.mH
        @Override // com.facebook.ads.redexgen.core.InterfaceC2740jM
        public final Object get() {
            return AnonymousClass99.A01();
        }
    };

    public static String A02(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i10, i10 + i11);
        int i13 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A09[7].charAt(23) != 't') {
                throw new RuntimeException();
            }
            A09[4] = "2gbF6ls";
            if (i13 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 26);
            i13++;
        }
    }

    public static void A03() {
        A08 = new byte[]{20, 35, 35, 62, 35, 113, 56, 63, 34, 37, 48, 63, 37, 56, 48, 37, 56, 63, 54, 113, 21, 52, 55, 48, 36, 61, 37, 20, 41, 37, 35, 48, 50, 37, 62, 35, 34, 23, 48, 50, 37, 62, 35, 40, 106, 102, 100, 39, 111, 104, 106, 108, 107, 102, 102, 98, 39, 104, 109, 122, 39, 104, 103, 109, 123, 102, 96, 109, 113, 39, 100, 108, 109, 96, 104, 58, 39, 108, 113, 125, 123, 104, 106, 125, 102, 123, 39, 77, 108, 111, 104, 124, 101, 125, 76, 113, 125, 123, 104, 106, 125, 102, 123, 122, 79, 104, 106, 125, 102, 123, 112};
    }

    static {
        A03();
    }

    public AnonymousClass99(InterfaceC13984w interfaceC13984w) {
        this.A06 = interfaceC13984w;
    }

    public static /* synthetic */ C2917mR A00(InterfaceC1673Gb interfaceC1673Gb, C14667m c14667m) {
        return new C2917mR(interfaceC1673Gb);
    }

    public static /* synthetic */ InterfaceExecutorC1645Ez A01() {
        return null;
    }

    @MetaExoPlayerCustomization("Custom reflection logic to avoid loading DefaultExtractorsFactory")
    public final AnonymousClass98 A04(Uri uri) {
        String strA02 = A02(0, 44, 75);
        if (this.A02 == null) {
            try {
                Constructor<? extends ExtractorsFactory> constructor = Class.forName(A02(44, 67, 19)).asSubclass(InterfaceC1673Gb.class).getConstructor(new Class[0]);
                final InterfaceC1673Gb interfaceC1673Gb = (InterfaceC1673Gb) constructor.newInstance(new Object[0]);
                this.A02 = new InterfaceC1568Ca() { // from class: com.facebook.ads.redexgen.X.mI
                    @Override // com.facebook.ads.redexgen.core.InterfaceC1568Ca
                    public final InterfaceC1569Cb A5P(C14667m c14667m) {
                        return AnonymousClass99.A00(interfaceC1673Gb, c14667m);
                    }
                };
            } catch (ClassNotFoundException e10) {
                throw new RuntimeException(strA02, e10);
            } catch (IllegalAccessException e11) {
                throw new RuntimeException(strA02, e11);
            } catch (InstantiationException e12) {
                throw new RuntimeException(strA02, e12);
            } catch (NoSuchMethodException e13) {
                throw new RuntimeException(strA02, e13);
            } catch (InvocationTargetException e14) {
                throw new RuntimeException(strA02, e14);
            }
        }
        return new AnonymousClass98(new C2I().A00(uri).A02(this.A05).A01(this.A07).A05(), this.A06, this.A02, this.A01, this.A03, this.A00, null);
    }
}
