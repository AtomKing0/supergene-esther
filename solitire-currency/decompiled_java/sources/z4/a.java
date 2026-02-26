package z4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: compiled from: ExtendableSavedState.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends AbsSavedState {
    public static final Parcelable.Creator<a> CREATOR = new C0764a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final SimpleArrayMap<String, Bundle> f37564a;

    /* JADX INFO: renamed from: z4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExtendableSavedState.java */
    class C0764a implements Parcelable.ClassLoaderCreator<a> {
        C0764a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(@NonNull Parcel parcel) {
            return new a(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    /* synthetic */ a(Parcel parcel, ClassLoader classLoader, C0764a c0764a) {
        this(parcel, classLoader);
    }

    @NonNull
    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f37564a + "}";
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        int size = this.f37564a.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = this.f37564a.keyAt(i11);
            bundleArr[i11] = this.f37564a.valueAt(i11);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f37564a = new SimpleArrayMap<>();
    }

    private a(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i10 = parcel.readInt();
        String[] strArr = new String[i10];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i10];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f37564a = new SimpleArrayMap<>(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            this.f37564a.put(strArr[i11], bundleArr[i11]);
        }
    }
}
