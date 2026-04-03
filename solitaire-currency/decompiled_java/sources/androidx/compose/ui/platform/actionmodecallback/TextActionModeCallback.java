package androidx.compose.ui.platform.actionmodecallback;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.geometry.Rect;
import h9.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextActionModeCallback.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextActionModeCallback {

    @Nullable
    private final a<k0> onActionModeDestroy;

    @Nullable
    private a<k0> onCopyRequested;

    @Nullable
    private a<k0> onCutRequested;

    @Nullable
    private a<k0> onPasteRequested;

    @Nullable
    private a<k0> onSelectAllRequested;

    @NotNull
    private Rect rect;

    public TextActionModeCallback() {
        this(null, null, null, null, null, null, 63, null);
    }

    private final void addOrRemoveMenuItem(Menu menu, MenuItemOption menuItemOption, a<k0> aVar) {
        if (aVar != null && menu.findItem(menuItemOption.getId()) == null) {
            addMenuItem$ui_release(menu, menuItemOption);
        } else {
            if (aVar != null || menu.findItem(menuItemOption.getId()) == null) {
                return;
            }
            menu.removeItem(menuItemOption.getId());
        }
    }

    public final void addMenuItem$ui_release(@NotNull Menu menu, @NotNull MenuItemOption item) {
        t.i(menu, "menu");
        t.i(item, "item");
        menu.add(0, item.getId(), item.getOrder(), item.getTitleResource()).setShowAsAction(1);
    }

    @Nullable
    public final a<k0> getOnActionModeDestroy() {
        return this.onActionModeDestroy;
    }

    @Nullable
    public final a<k0> getOnCopyRequested() {
        return this.onCopyRequested;
    }

    @Nullable
    public final a<k0> getOnCutRequested() {
        return this.onCutRequested;
    }

    @Nullable
    public final a<k0> getOnPasteRequested() {
        return this.onPasteRequested;
    }

    @Nullable
    public final a<k0> getOnSelectAllRequested() {
        return this.onSelectAllRequested;
    }

    @NotNull
    public final Rect getRect() {
        return this.rect;
    }

    public final boolean onActionItemClicked(@Nullable ActionMode actionMode, @Nullable MenuItem menuItem) {
        t.f(menuItem);
        int itemId = menuItem.getItemId();
        if (itemId == MenuItemOption.Copy.getId()) {
            a<k0> aVar = this.onCopyRequested;
            if (aVar != null) {
                aVar.invoke();
            }
        } else if (itemId == MenuItemOption.Paste.getId()) {
            a<k0> aVar2 = this.onPasteRequested;
            if (aVar2 != null) {
                aVar2.invoke();
            }
        } else if (itemId == MenuItemOption.Cut.getId()) {
            a<k0> aVar3 = this.onCutRequested;
            if (aVar3 != null) {
                aVar3.invoke();
            }
        } else {
            if (itemId != MenuItemOption.SelectAll.getId()) {
                return false;
            }
            a<k0> aVar4 = this.onSelectAllRequested;
            if (aVar4 != null) {
                aVar4.invoke();
            }
        }
        if (actionMode == null) {
            return true;
        }
        actionMode.finish();
        return true;
    }

    public final boolean onCreateActionMode(@Nullable ActionMode actionMode, @Nullable Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (actionMode == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (this.onCopyRequested != null) {
            addMenuItem$ui_release(menu, MenuItemOption.Copy);
        }
        if (this.onPasteRequested != null) {
            addMenuItem$ui_release(menu, MenuItemOption.Paste);
        }
        if (this.onCutRequested != null) {
            addMenuItem$ui_release(menu, MenuItemOption.Cut);
        }
        if (this.onSelectAllRequested == null) {
            return true;
        }
        addMenuItem$ui_release(menu, MenuItemOption.SelectAll);
        return true;
    }

    public final void onDestroyActionMode() {
        a<k0> aVar = this.onActionModeDestroy;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final boolean onPrepareActionMode(@Nullable ActionMode actionMode, @Nullable Menu menu) {
        if (actionMode == null || menu == null) {
            return false;
        }
        updateMenuItems$ui_release(menu);
        return true;
    }

    public final void setOnCopyRequested(@Nullable a<k0> aVar) {
        this.onCopyRequested = aVar;
    }

    public final void setOnCutRequested(@Nullable a<k0> aVar) {
        this.onCutRequested = aVar;
    }

    public final void setOnPasteRequested(@Nullable a<k0> aVar) {
        this.onPasteRequested = aVar;
    }

    public final void setOnSelectAllRequested(@Nullable a<k0> aVar) {
        this.onSelectAllRequested = aVar;
    }

    public final void setRect(@NotNull Rect rect) {
        t.i(rect, "<set-?>");
        this.rect = rect;
    }

    @VisibleForTesting
    public final void updateMenuItems$ui_release(@NotNull Menu menu) {
        t.i(menu, "menu");
        addOrRemoveMenuItem(menu, MenuItemOption.Copy, this.onCopyRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.Paste, this.onPasteRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.Cut, this.onCutRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.SelectAll, this.onSelectAllRequested);
    }

    public TextActionModeCallback(@Nullable a<k0> aVar, @NotNull Rect rect, @Nullable a<k0> aVar2, @Nullable a<k0> aVar3, @Nullable a<k0> aVar4, @Nullable a<k0> aVar5) {
        t.i(rect, "rect");
        this.onActionModeDestroy = aVar;
        this.rect = rect;
        this.onCopyRequested = aVar2;
        this.onPasteRequested = aVar3;
        this.onCutRequested = aVar4;
        this.onSelectAllRequested = aVar5;
    }

    public /* synthetic */ TextActionModeCallback(a aVar, Rect rect, a aVar2, a aVar3, a aVar4, a aVar5, int i10, k kVar) {
        this((i10 & 1) != 0 ? null : aVar, (i10 & 2) != 0 ? Rect.Companion.getZero() : rect, (i10 & 4) != 0 ? null : aVar2, (i10 & 8) != 0 ? null : aVar3, (i10 & 16) != 0 ? null : aVar4, (i10 & 32) != 0 ? null : aVar5);
    }
}
