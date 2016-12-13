(ns micro-business.userui.mutate
  (:require
   [om.next :as om]))

(defmulti mutate om/dispatch)
