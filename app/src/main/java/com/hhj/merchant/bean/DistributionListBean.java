package com.hhj.merchant.bean;

public class DistributionListBean {

    /**
     * result : [{"deliveryTime":"2019-05-08","id":124,"deliveryNumber":"919050819313578731582","deliveryStatus":3},{"deliveryTime":"2019-05-09","id":125,"deliveryNumber":"919050819313578735602","deliveryStatus":3},{"deliveryTime":"2019-05-10","id":126,"deliveryNumber":"919050819313578742951","deliveryStatus":2},{"deliveryTime":"2019-05-13","id":127,"deliveryNumber":"919050819313578727931","deliveryStatus":2},{"deliveryTime":"2019-05-14","id":128,"deliveryNumber":"919050819313578759061","deliveryStatus":2},{"deliveryTime":"2019-05-15","id":129,"deliveryNumber":"919050819313578765983","deliveryStatus":2},{"deliveryTime":"2019-05-16","id":130,"deliveryNumber":"919050819313578772560","deliveryStatus":2},{"deliveryTime":"2019-05-17","id":131,"deliveryNumber":"919050819313578757230","deliveryStatus":2},{"deliveryTime":"2019-05-20","id":132,"deliveryNumber":"919050819313578769372","deliveryStatus":2},{"deliveryTime":"2019-05-21","id":133,"deliveryNumber":"919050819313578780153","deliveryStatus":2},{"deliveryTime":"2019-05-22","id":134,"deliveryNumber":"919050819313578757890","deliveryStatus":2},{"deliveryTime":"2019-05-23","id":135,"deliveryNumber":"919050819313578767409","deliveryStatus":2},{"deliveryTime":"2019-05-24","id":136,"deliveryNumber":"919050819313578716572","deliveryStatus":2}]
     * success : true
     * message :
     * code :
     * pager : null
     */
        /**
         * deliveryTime : 2019-05-08
         * id : 124
         * deliveryNumber : 919050819313578731582
         * deliveryStatus : 3
         */

        private String deliveryTime;
        private String id;
        private String deliveryNumber;
        private String deliveryStatus;

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        private boolean isChecked;

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDeliveryNumber() {
            return deliveryNumber;
        }

        public void setDeliveryNumber(String deliveryNumber) {
            this.deliveryNumber = deliveryNumber;
        }

        public String getDeliveryStatus() {
            return deliveryStatus;
        }

        public void setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }
}
