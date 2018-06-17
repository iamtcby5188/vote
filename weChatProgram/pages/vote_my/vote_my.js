// pages/vote_my/vote_my.js
const app = getApp()
const constant = require("../../utils/constant.js")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    vote_list:[],
    item_image:{
      edit:"../../resources/item_image/edit.png",
      del: "../../resources/item_image/del.png",
      display: "../../resources/item_image/display.png",
    },
    showIndex:-1
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  onTabItemTap(item) {
    console.log(item.index)
    console.log(item.pagePath)
    console.log(item.text)
   
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
      url: constant.getUrl(constant.request_url.getMyVote),
      data: {
        user_id: app.globalData.userInfo.id,
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: res => {
        console.log(res);
        this.setData({
          vote_list:res.data
        })
        console.log(this.data         .vote_list)
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
  clickItem:function(e){
    this.setData({ showIndex: e.currentTarget.id})

    console.log(this.data.showIndex)
  }
})