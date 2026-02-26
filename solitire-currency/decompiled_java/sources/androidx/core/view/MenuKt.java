package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MenuKt {

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: Menu.kt */
    public static final class AnonymousClass1 implements Iterator<MenuItem>, i9.a {
        final /* synthetic */ Menu $this_iterator;
        private int index;

        AnonymousClass1(Menu menu) {
            this.$this_iterator = menu;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            v8.k0 k0Var;
            Menu menu = this.$this_iterator;
            int i10 = this.index - 1;
            this.index = i10;
            MenuItem item = menu.getItem(i10);
            if (item != null) {
                menu.removeItem(item.getItemId());
                k0Var = v8.k0.f35197a;
            } else {
                k0Var = null;
            }
            if (k0Var == null) {
                throw new IndexOutOfBoundsException();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @NotNull
        public MenuItem next() {
            Menu menu = this.$this_iterator;
            int i10 = this.index;
            this.index = i10 + 1;
            MenuItem item = menu.getItem(i10);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (kotlin.jvm.internal.t.d(menu.getItem(i10), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@NotNull Menu menu, @NotNull h9.l<? super MenuItem, v8.k0> lVar) {
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            lVar.invoke(menu.getItem(i10));
        }
    }

    public static final void forEachIndexed(@NotNull Menu menu, @NotNull h9.p<? super Integer, ? super MenuItem, v8.k0> pVar) {
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.mo4invoke(Integer.valueOf(i10), menu.getItem(i10));
        }
    }

    @NotNull
    public static final MenuItem get(@NotNull Menu menu, int i10) {
        return menu.getItem(i10);
    }

    @NotNull
    public static final o9.g<MenuItem> getChildren(@NotNull final Menu menu) {
        return new o9.g<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // o9.g
            @NotNull
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(@NotNull Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(@NotNull Menu menu) {
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull Menu menu) {
        return menu.size() != 0;
    }

    @NotNull
    public static final Iterator<MenuItem> iterator(@NotNull Menu menu) {
        return new AnonymousClass1(menu);
    }

    public static final void minusAssign(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(@NotNull Menu menu, int i10) {
        v8.k0 k0Var;
        MenuItem item = menu.getItem(i10);
        if (item != null) {
            menu.removeItem(item.getItemId());
            k0Var = v8.k0.f35197a;
        } else {
            k0Var = null;
        }
        if (k0Var == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
