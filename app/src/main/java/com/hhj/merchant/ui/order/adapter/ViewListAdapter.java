package com.hhj.merchant.ui.order.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.adapter
 * @ClassName: ViewListAdapter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/17 22:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/17 22:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ViewListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ViewListAdapter() {
        super(R.layout.item_view_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.textView,item);
    }
}
