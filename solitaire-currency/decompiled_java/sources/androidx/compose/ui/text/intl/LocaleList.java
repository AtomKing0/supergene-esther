package androidx.compose.ui.text.intl;

import androidx.compose.runtime.Immutable;
import i9.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.collections.p;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.r;

/* JADX INFO: compiled from: LocaleList.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class LocaleList implements Collection<Locale>, a {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final List<Locale> localeList;
    private final int size;

    /* JADX INFO: compiled from: LocaleList.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final LocaleList getCurrent() {
            List<PlatformLocale> current = PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent();
            ArrayList arrayList = new ArrayList(current.size());
            int size = current.size();
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.add(new Locale(current.get(i10)));
            }
            return new LocaleList(arrayList);
        }
    }

    public LocaleList(@NotNull List<Locale> localeList) {
        t.i(localeList, "localeList");
        this.localeList = localeList;
        this.size = localeList.size();
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public boolean add2(Locale locale) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends Locale> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Locale) {
            return contains((Locale) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        return this.localeList.containsAll(elements);
    }

    @Override // java.util.Collection
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocaleList) && t.d(this.localeList, ((LocaleList) obj).localeList);
    }

    @NotNull
    public final Locale get(int i10) {
        return this.localeList.get(i10);
    }

    @NotNull
    public final List<Locale> getLocaleList() {
        return this.localeList;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.localeList.hashCode();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.localeList.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<Locale> iterator() {
        return this.localeList.iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super Locale> predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return j.a(this);
    }

    @NotNull
    public String toString() {
        return "LocaleList(localeList=" + this.localeList + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Locale locale) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(@NotNull Locale element) {
        t.i(element, "element");
        return this.localeList.contains(element);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        t.i(array, "array");
        return (T[]) j.b(this, array);
    }

    public LocaleList(@NotNull String languageTags) {
        t.i(languageTags, "languageTags");
        List listC0 = r.C0(languageTags, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(listC0.size());
        int size = listC0.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(r.b1((String) listC0.get(i10)).toString());
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            arrayList2.add(new Locale((String) arrayList.get(i11)));
        }
        this(arrayList2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocaleList(@NotNull Locale... locales) {
        this((List<Locale>) p.o0(locales));
        t.i(locales, "locales");
    }
}
