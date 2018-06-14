// pages/vote_index/vote_index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    mutil_selection:{
      model:'aspectFit',
      src:"../../resources/vote_index/mutil_selection.jpg"
    },
    single_selection:{
      model: 'aspectFit',
      src: "../../resources/vote_index/single_selection.jpg"
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.debug("vote index");
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },
  clickMutilImage : function(){
    console.log("click mutilImage")
    wx.navigateTo({
      url: '../vote/vote?type=2'
    })
  },
  clickSingleImage:function(){
    console.log("click singleImgae")
    wx.navigateTo({
      url: '../vote/vote?type=1'
    })
  }
})