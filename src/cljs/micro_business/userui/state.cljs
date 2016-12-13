(ns micro-business.userui.state
  (:require
   [micro-business.userui.signinpage.state :as signinpage]))

(def state
  {:signin-page signinpage/state})
