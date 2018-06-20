// pages/user_vote/user_vote.js
const constant = require("../../utils/constant.js")
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    vote_id:null,
    vote:null,
    option_selected:[],
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
            let option_list = res.data[0].option_list;
            for(let i = 0 ; i < option_list.length;++i){
              option_list[i].checked = false
            }
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
    if (this.data.option_selected == null || this.data.option_selected.length <=0)
    {
      wx.showModal({
        title: '提示',
        content: '必须选择一个选项',
        showCancel: false
      })
      return
    }

    wx.showModal({
      title: '提示',
      content: '确认提交',
      success: res=>{
        if(res.confirm){
          this.sendVoteToServer()
        }
      }
    })
  },
  sendVoteToServer:function(){
    var optionLst = [];
    for (let i = 0; i < this.data.option_selected.length; ++i) {
      optionLst.push({ vote_option_id: this.data.option_selected[i] })
    }

    wx.request({
      url: constant.getUrl(constant.request_url.vote),
      method: 'POST',
      header: {
        'content-type': 'application/json' // 默认值
      },
      data: {
        vote_id: this.data.vote.id,
        user_id: app.globalData.userInfo.id,
        lst_user_vote_option: optionLst,
      },
      success: res => {
        wx.navigateBack({
          delta: 1
        })
      },
      fail: res => {
        console.log("failed")
      }
    })
  },
  checkboxChange:function(e){
    this.setData({ option_selected:e.detail.value})
  },
  radioChange:function(e){
    let option_lst =[];
    option_lst.push(e.detail.value)
    this.setData({ option_selected: option_lst })
  }
})