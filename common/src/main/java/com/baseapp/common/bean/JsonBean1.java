package com.baseapp.common.bean;


import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

/**
 * TODO<json数据源>
 *
 * @author: 小嵩
 * @date: 2017/3/16 15:36
 */

public class JsonBean1 implements IPickerViewData {
    /**
     * areaId : CN01
     * areaName : 北京
     * cities : [{"areaId":"CN0101","areaName":"市辖区","counties":[{"areaId":"CN010101","areaName":"东城区"},{"areaId":"CN010102","areaName":"西城区"},{"areaId":"CN010103","areaName":"崇文区"},{"areaId":"CN010104","areaName":"宣武区"},{"areaId":"CN010105","areaName":"朝阳区"},{"areaId":"CN010106","areaName":"丰台区"},{"areaId":"CN010107","areaName":"石景山区"},{"areaId":"CN010108","areaName":"海淀区"},{"areaId":"CN010109","areaName":"门头沟区"},{"areaId":"CN010110","areaName":"房山区"},{"areaId":"CN010111","areaName":"通州区"},{"areaId":"CN010112","areaName":"顺义区"},{"areaId":"CN010113","areaName":"昌平区"},{"areaId":"CN010114","areaName":"大兴区"},{"areaId":"CN010115","areaName":"怀柔区"},{"areaId":"CN010116","areaName":"平谷区"}]},{"areaId":"CN0102","areaName":"县","counties":[{"areaId":"CN010201","areaName":"密云县"},{"areaId":"CN010202","areaName":"延庆县"}]}]
     */

    private String areaId;
    private String areaName;
    private List<CitiesBean> cities;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<CitiesBean> getCities() {
        return cities;
    }

    public void setCities(List<CitiesBean> cities) {
        this.cities = cities;
    }

    @Override
    public String getPickerViewText() {
        return this.getAreaName();
    }

    public static class CitiesBean {
        /**
         * areaId : CN0101
         * areaName : 市辖区
         * counties : [{"areaId":"CN010101","areaName":"东城区"},{"areaId":"CN010102","areaName":"西城区"},{"areaId":"CN010103","areaName":"崇文区"},{"areaId":"CN010104","areaName":"宣武区"},{"areaId":"CN010105","areaName":"朝阳区"},{"areaId":"CN010106","areaName":"丰台区"},{"areaId":"CN010107","areaName":"石景山区"},{"areaId":"CN010108","areaName":"海淀区"},{"areaId":"CN010109","areaName":"门头沟区"},{"areaId":"CN010110","areaName":"房山区"},{"areaId":"CN010111","areaName":"通州区"},{"areaId":"CN010112","areaName":"顺义区"},{"areaId":"CN010113","areaName":"昌平区"},{"areaId":"CN010114","areaName":"大兴区"},{"areaId":"CN010115","areaName":"怀柔区"},{"areaId":"CN010116","areaName":"平谷区"}]
         */

        private String areaId;
        private String areaName;
        private List<CountiesBean> counties;

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public List<CountiesBean> getCounties() {
            return counties;
        }

        public void setCounties(List<CountiesBean> counties) {
            this.counties = counties;
        }

        public static class CountiesBean {
            /**
             * areaId : CN010101
             * areaName : 东城区
             */

            private String areaId;
            private String areaName;

            public String getAreaId() {
                return areaId;
            }

            public void setAreaId(String areaId) {
                this.areaId = areaId;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }
        }
    }
}
