/**
 * 
 */
package com.rockchips.mediacenter.view;
import org.xutils.view.annotation.ViewInject;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.rockchips.mediacenter.R;
/**
 * @author GaoFei
 * 文件删除提示对话框
 */
public class FileDeleteTipDialog extends AppBaseDialog implements View.OnClickListener{
	
	@ViewInject(R.id.btn_ok)
	private Button mBtnOK;
	@ViewInject(R.id.btn_cancel)
	private Button mBtnCancel;
	
	public interface CallBack{
		void onOK();
		void onCancel();
	}
	
	private CallBack mCallBack;
	
	public FileDeleteTipDialog(Context context, CallBack callBack) {
		super(context);
		setCancelable(false);
		mCallBack = callBack;
	}

	@Override
	public int getLayoutRes() {
		return R.layout.dialog_file_delete_tip;
	}

	@Override
	public void initData() {
		
	}

	@Override
	public void initEvent() {
		mBtnOK.setOnClickListener(this);
		mBtnCancel.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if(view.getId() == R.id.btn_ok){
			dismiss();
			mCallBack.onOK();
		}else{
			mCallBack.onCancel();
		}
	}
	
	
}