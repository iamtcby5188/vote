// pages/vote_cal/vote_cal.js
const app = getApp()
const constant = require("../../utils/constant.js")
const util = require("../../utils/util.js")

Page({

  /**
   * 页面的初始数据
   */
  data: {
    vote_list: [],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
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
    wx.request({
      url: constant.getUrl(constant.request_url.getAttendVote),
      data: {
        attend_user_id: app.globalData.userInfo.id,
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: res => {
        console.log(res);
        this.setData({
          vote_list: res.data
        })
      },
      fail: res => {
        console.log("longin_service failed");
      }
    })
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
  clickItem: function (e) {
    console.log(e.currentTarget.id)
    let item_index = e.currentTarget.id;
    let item = this.data.vote_list[item_index]
    wx.navigateTo({
      url: '../vote_cal_display/vote_cal_display?item=' + util.obj2Json(item),
    })
  },
})