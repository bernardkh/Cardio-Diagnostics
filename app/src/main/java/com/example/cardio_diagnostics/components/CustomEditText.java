package com.example.cardio_diagnostics.components;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.cardio_diagnostics.R;
import com.example.cardio_diagnostics.databinding.CustomEditTextBinding;
import com.google.android.material.textfield.TextInputLayout;

import static com.google.android.material.textfield.TextInputLayout.END_ICON_NONE;


public class CustomEditText extends ConstraintLayout {

    private Context mContext;
    private View mainLay;
    private TextView txLabel;
    private TextView txtError;
    private AppCompatEditText etText;
    private TextInputLayout layoutTextInput;
    private ImageView ivArrow;
    private String labelStr = null;
    int inputTypes = 0;
    private boolean isDropDown = false;
    private CustomEditTextBinding customEditTextBinding;


    public CustomEditText(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleAttr);
    }



    private void init(AttributeSet attrs, int defStyle) {
        mContext = getContext();
        /*View view = LayoutInflater
                .from(getContext())
                .inflate(R.layout.custom_edit_text,
                        this,
                        true);*/
        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        customEditTextBinding = CustomEditTextBinding.inflate(inflater,this,
                true);

        //if (isInEditMode()) return;
       /* txLabel = view.findViewById(R.id.txt_label);
        txtError = view.findViewById(R.id.txt_error);
        etText = view.findViewById(R.id.et_text);
        ivArrow = view.findViewById(R.id.iv_arrow);
        mainLay = view.findViewById(R.id.mainLay);
        layoutTextInput = view.findViewById(R.id.layoutTextInput); */
        txLabel = customEditTextBinding.txtLabel;
        txtError = customEditTextBinding.txtError;
        etText = customEditTextBinding.etText;
        ivArrow = customEditTextBinding.ivArrow;
        mainLay = customEditTextBinding.mainLay;
        layoutTextInput = customEditTextBinding.layoutTextInput;

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomEditText, 0, 0);

        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = typedArray.getIndex(i);
            if(attr == R.styleable.CustomEditText_android_inputType) {
                inputTypes = typedArray.getInt(attr, EditorInfo.TYPE_NULL);
            }else if(attr == R.styleable.CustomEditText_label) {
                labelStr = typedArray.getString(attr);
            }else if(attr == R.styleable.CustomEditText_is_drop_down) {
                isDropDown = typedArray.getBoolean(attr, false);
            }
        }
        typedArray.recycle();
        setupViews();
    }

    private void setupViews() {

        if(labelStr != null){
            txLabel.setText(labelStr);
        }

        if(isDropDown){
            ivArrow.setVisibility(View.VISIBLE);
            mainLay.setVisibility(View.VISIBLE);
            /*mainLay.setOnClickListener(v -> {
                if(this.listener != null){
                    this.listener.openCountryDialog(this.getId());
                }
            });*/
        }else{
            ivArrow.setVisibility(View.GONE);
            mainLay.setVisibility(View.GONE);
            mainLay.setOnClickListener(null);
        }

        if(inputTypes > 0){
            etText.setInputType(inputTypes);
            if((inputTypes - 1) == InputType.TYPE_TEXT_VARIATION_PASSWORD){
                layoutTextInput.setEndIconMode(TextInputLayout.END_ICON_PASSWORD_TOGGLE);
                layoutTextInput.setEndIconTintList(ColorStateList.valueOf(mContext.getResources().getColor(R.color.txt_color_grey)));
            }else{
                layoutTextInput.setEndIconMode(END_ICON_NONE);
            }
        }

        etText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setError(null);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void setError(String error) {
        if(txtError == null)return;
        if(error == null){
            txtError.setVisibility(View.GONE);
        }else{
            txtError.setText(error);
            txtError.setVisibility(View.VISIBLE);
        }
    }

    public void setText(String value) {
        if(etText == null)return;
        if(value != null){
            etText.setText(value);
        }
    }

    public String getText() {
        if(etText == null)return "";
        if(etText.getText() != null){
            return etText.getText().toString();
        }else{
            return "";
        }
    }

}
