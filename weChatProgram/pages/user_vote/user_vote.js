// pages/user_vote/user_vote.js
const constant = require("../../utils/constant.js")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    vote_id:null,
    vote:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      this.setData({vote_id:options.vote_id});
      wx.request({
        url: constant.getUrl(constant.request_url.getVoteById),
        data: {
          id: options.vote_id,
        },
        method: 'GET',
        header: {
          'content-type': 'application/json' // 默认值
        },
        success:res=>{
          if(res && res.data && res.data.length > 0){
            this.setData({vote:res.data[0]})
          }
            console.log(this.data.vote)
        },

      })
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
  clickCommit:function(e){
    console.log(e)
  }
})