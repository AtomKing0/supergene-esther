package com.braze.ui.contentcards.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.braze.ui.R$drawable;
import com.braze.ui.R$id;
import java.util.Locale;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContentCardViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ContentCardViewHolder extends RecyclerView.ViewHolder {

    @Nullable
    private final TextView actionHint;

    @Nullable
    private final ImageView pinnedIcon;

    @Nullable
    private final View unreadBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentCardViewHolder(@NotNull View view, boolean z10) {
        super(view);
        t.i(view, "view");
        View viewFindViewById = view.findViewById(R$id.com_braze_content_cards_unread_bar);
        this.unreadBar = viewFindViewById;
        this.pinnedIcon = (ImageView) view.findViewById(R$id.com_braze_content_cards_pinned_icon);
        this.actionHint = (TextView) view.findViewById(R$id.com_braze_content_cards_action_hint);
        if (!z10) {
            if (viewFindViewById == null) {
                return;
            }
            viewFindViewById.setVisibility(8);
        } else {
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
            }
            if (viewFindViewById == null) {
                return;
            }
            viewFindViewById.setBackground(view.getContext().getResources().getDrawable(R$drawable.com_braze_content_cards_unread_bar_background));
        }
    }

    public final void setActionHintText(@NotNull String text) {
        t.i(text, "text");
        TextView textView = this.actionHint;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setActionHintVisible(boolean z10) {
        TextView textView = this.actionHint;
        if (textView == null) {
            return;
        }
        textView.setVisibility(z10 ? 0 : 8);
    }

    public final void setPinnedIconVisible(boolean z10) {
        ImageView imageView;
        ImageView imageView2 = this.pinnedIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(z10 ? 0 : 8);
        }
        if (z10) {
            Locale locale = Locale.getDefault();
            t.h(locale, "getDefault()");
            if (TextUtils.getLayoutDirectionFromLocale(locale) != 1 || (imageView = this.pinnedIcon) == null) {
                return;
            }
            imageView.setScaleX(-1.0f);
        }
    }

    public final void setUnreadBarVisible(boolean z10) {
        View view = this.unreadBar;
        if (view == null) {
            return;
        }
        view.setVisibility(z10 ? 0 : 8);
    }
}
