package com.hhj.merchant.ui.order.adapter;

import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.adapter
 * @ClassName: DialogListAdapter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/17 14:14
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/17 14:14
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DialogListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public String sellerCancelReason = "";
    public  int position=-1;
    public DialogListAdapter() {
        super(R.layout.item_dialog_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        final CheckBox checkBox = helper.getView(R.id.radioButton);
        if (position==helper.getAdapterPosition()){
            sellerCancelReason=item;
            checkBox.setChecked(true);
        }else {
            checkBox.setChecked(false);
        }
        checkBox.setText(item);
    }
}
