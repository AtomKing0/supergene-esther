package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiEditTextHelper {
    private int mEmojiReplaceStrategy;
    private final HelperInternal mHelper;
    private int mMaxEmojiCount;

    @RequiresApi(19)
    private static class HelperInternal19 extends HelperInternal {
        private final EditText mEditText;
        private final EmojiTextWatcher mTextWatcher;

        HelperInternal19(@NonNull EditText editText, boolean z10) {
            this.mEditText = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, z10);
            this.mTextWatcher = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        KeyListener getKeyListener(@Nullable KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new EmojiKeyListener(keyListener);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        boolean isEnabled() {
            return this.mTextWatcher.isEnabled();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        InputConnection onCreateInputConnection(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            return inputConnection instanceof EmojiInputConnection ? inputConnection : new EmojiInputConnection(this.mEditText, inputConnection, editorInfo);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setEmojiReplaceStrategy(int i10) {
            this.mTextWatcher.setEmojiReplaceStrategy(i10);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setEnabled(boolean z10) {
            this.mTextWatcher.setEnabled(z10);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setMaxEmojiCount(int i10) {
            this.mTextWatcher.setMaxEmojiCount(i10);
        }
    }

    public EmojiEditTextHelper(@NonNull EditText editText) {
        this(editText, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    @Nullable
    public KeyListener getKeyListener(@Nullable KeyListener keyListener) {
        return this.mHelper.getKeyListener(keyListener);
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    @Nullable
    public InputConnection onCreateInputConnection(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.mHelper.onCreateInputConnection(inputConnection, editorInfo);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEmojiReplaceStrategy(int i10) {
        this.mEmojiReplaceStrategy = i10;
        this.mHelper.setEmojiReplaceStrategy(i10);
    }

    public void setEnabled(boolean z10) {
        this.mHelper.setEnabled(z10);
    }

    public void setMaxEmojiCount(@IntRange(from = 0) int i10) {
        Preconditions.checkArgumentNonnegative(i10, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = i10;
        this.mHelper.setMaxEmojiCount(i10);
    }

    public EmojiEditTextHelper(@NonNull EditText editText, boolean z10) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        Preconditions.checkNotNull(editText, "editText cannot be null");
        this.mHelper = new HelperInternal19(editText, z10);
    }

    static class HelperInternal {
        HelperInternal() {
        }

        boolean isEnabled() {
            return false;
        }

        @Nullable
        KeyListener getKeyListener(@Nullable KeyListener keyListener) {
            return keyListener;
        }

        void setEmojiReplaceStrategy(int i10) {
        }

        void setEnabled(boolean z10) {
        }

        void setMaxEmojiCount(int i10) {
        }

        InputConnection onCreateInputConnection(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            return inputConnection;
        }
    }
}
