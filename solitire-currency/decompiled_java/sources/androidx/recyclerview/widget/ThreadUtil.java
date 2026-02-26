package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.TileList;

/* JADX INFO: loaded from: classes2.dex */
interface ThreadUtil<T> {

    public interface BackgroundCallback<T> {
        void loadTile(int i10, int i11);

        @SuppressLint({"UnknownNullness"})
        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i10);

        void updateRange(int i10, int i11, int i12, int i13, int i14);
    }

    public interface MainThreadCallback<T> {
        @SuppressLint({"UnknownNullness"})
        void addTile(int i10, TileList.Tile<T> tile);

        void removeTile(int i10, int i11);

        void updateItemCount(int i10, int i11);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback);
}
