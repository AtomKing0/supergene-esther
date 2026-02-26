package h3;

import a4.o0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.services.UnityAdsConstants;
import java.util.ArrayList;
import java.util.List;
import k2.b2;

/* JADX INFO: compiled from: TextInformationFrame.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends i {
    public static final Parcelable.Creator<m> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f26462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f26463c;

    /* JADX INFO: compiled from: TextInformationFrame.java */
    class a implements Parcelable.Creator<m> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i10) {
            return new m[i10];
        }
    }

    public m(String str, @Nullable String str2, String str3) {
        super(str);
        this.f26462b = str2;
        this.f26463c = str3;
    }

    private static List<Integer> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return o0.c(this.f26451a, mVar.f26451a) && o0.c(this.f26462b, mVar.f26462b) && o0.c(this.f26463c, mVar.f26463c);
    }

    public int hashCode() {
        int iHashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f26451a.hashCode()) * 31;
        String str = this.f26462b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f26463c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // h3.i, c3.a.b
    public void i(b2.b bVar) {
        String str = this.f26451a;
        str.hashCode();
        byte b10 = -1;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    b10 = 0;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    b10 = 1;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    b10 = 2;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    b10 = 3;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    b10 = 4;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    b10 = 5;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    b10 = 6;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    b10 = 7;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    b10 = 8;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    b10 = 9;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    b10 = 10;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    b10 = 11;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    b10 = 12;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    b10 = 13;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    b10 = 14;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    b10 = 15;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    b10 = 16;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    b10 = 17;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    b10 = 18;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    b10 = 19;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    b10 = 20;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    b10 = 21;
                }
                break;
        }
        try {
            switch (b10) {
                case 0:
                case 10:
                    bVar.L(this.f26463c);
                    break;
                case 1:
                case 11:
                    bVar.Q(this.f26463c);
                    break;
                case 2:
                case 12:
                    bVar.b0(Integer.valueOf(Integer.parseInt(this.f26463c.substring(2, 4)))).a0(Integer.valueOf(Integer.parseInt(this.f26463c.substring(0, 2))));
                    break;
                case 3:
                case 17:
                    bVar.M(this.f26463c);
                    break;
                case 4:
                case 18:
                    bVar.K(this.f26463c);
                    break;
                case 5:
                case 19:
                    bVar.R(this.f26463c);
                    break;
                case 6:
                case 20:
                    String[] strArrH0 = o0.H0(this.f26463c, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
                    bVar.l0(Integer.valueOf(Integer.parseInt(strArrH0[0]))).k0(strArrH0.length > 1 ? Integer.valueOf(Integer.parseInt(strArrH0[1])) : null);
                    break;
                case 7:
                case 16:
                    bVar.i0(this.f26463c);
                    break;
                case 8:
                case 15:
                    bVar.n0(this.f26463c);
                    break;
                case 9:
                case 21:
                    bVar.c0(Integer.valueOf(Integer.parseInt(this.f26463c)));
                    break;
                case 13:
                    List<Integer> listA = a(this.f26463c);
                    int size = listA.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                bVar.a0(listA.get(2));
                            }
                        }
                        bVar.b0(listA.get(1));
                    }
                    bVar.c0(listA.get(0));
                    break;
                case 14:
                    List<Integer> listA2 = a(this.f26463c);
                    int size2 = listA2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                bVar.d0(listA2.get(2));
                            }
                        }
                        bVar.e0(listA2.get(1));
                    }
                    bVar.f0(listA2.get(0));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    @Override // h3.i
    public String toString() {
        return this.f26451a + ": description=" + this.f26462b + ": value=" + this.f26463c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f26451a);
        parcel.writeString(this.f26462b);
        parcel.writeString(this.f26463c);
    }

    m(Parcel parcel) {
        super((String) o0.j(parcel.readString()));
        this.f26462b = parcel.readString();
        this.f26463c = (String) o0.j(parcel.readString());
    }
}
