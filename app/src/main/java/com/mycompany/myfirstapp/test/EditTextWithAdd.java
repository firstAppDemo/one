package com.mycompany.myfirstapp.test;

import android.content.Context;  
import android.graphics.Rect;  
import android.graphics.drawable.Drawable;  
import android.util.AttributeSet;  
import android.util.Log;  
import android.view.MotionEvent;  
import android.widget.EditText;

import com.mycompany.myfirstapp.R;

public class EditTextWithAdd extends EditText {
	
    private final static String TAG = "EditTextWithAdd";   
    private Drawable addIcon;    
    private Context mContext;   
    private EditTextWithAddInterFace baseEditTextWithAddInterFace;  
   public EditTextWithAdd(Context context) {  
       super(context);  
       mContext=context;  
       init();  
   }  
     
   public void setActivity(EditTextWithAddInterFace baseEditTextWithAddInterFace){  
      this.baseEditTextWithAddInterFace=baseEditTextWithAddInterFace;  
   }  
   public EditTextWithAdd(Context context,AttributeSet attrs) {  
       super(context,attrs);  
       mContext=context;  
       init();  
   }  
 
   public EditTextWithAdd(Context context, AttributeSet attrs, int defStyle) {  
       super(context, attrs, defStyle);  
       mContext = context;  
       init();  
   }  
    private void init() {  
        addIcon=mContext.getResources().getDrawable( R.drawable.add);
        addIcon.setBounds(0, 0, 40, 40);  
        setCompoundDrawables(null, null, addIcon, null);  
//       setCompoundDrawablesWithIntrinsicBounds(null, null, dateIcon, null);  
        this.setEnabled(false);  
    }  
    
    @Override    
    public boolean onTouchEvent(MotionEvent event) {    
        if (addIcon != null && event.getAction() == MotionEvent.ACTION_UP) {    
              int eventX = (int) event.getRawX();    
              int eventY = (int) event.getRawY();    
               Log.e(TAG, "eventX = " + eventX + "; eventY = " + eventY);    
              Rect rect = new Rect();    
              getGlobalVisibleRect(rect);    
               rect.left = rect.right - 81;    
              if(rect.contains(eventX, eventY)){  
                 if(baseEditTextWithAddInterFace!=null){  
                     baseEditTextWithAddInterFace.addButtonListener();  
                 }  
              }  
          }    
          return super.onTouchEvent(event);    
       }  

}
