import React, { useEffect } from 'react'

import { Calendar, momentLocalizer } from 'react-big-calendar'

import 'react-big-calendar/lib/css/react-big-calendar.css'
import moment from 'moment'
import {
  CCard,
  CCardBody,
  CRow,
  CCol,
  CInputGroup,
  CInputGroupText,
  CFormInput,
} from '@coreui/react'
import styled from 'styled-components'

import axios from 'axios'

const StyledCFormInput = styled(CFormInput)`
  text-align: right;
`

export const AccountBook = () => {
  moment.locale('ko-KR')
  const localizer = momentLocalizer(moment)

  useEffect(() => {
    axios('/financial/yahoo/AAPL', {
      method: 'GET',
    }).then((res) => {
      console.log('res.data : ', res.data)
    })
  }, [])

  return (
    <div style={{ height: 700 }}>
      <CRow>
        <CCol lg="9">
          <CCard>
            <CCardBody>
              <Calendar
                localizer={localizer}
                events={[
                  {
                    title: 'My event',
                    allDay: false,
                    start: new Date(2022, 2, 9), // 실제 month = month + 1
                    end: new Date(2022, 2, 9),
                    resource: 'hi',
                  },
                  {
                    title: 'My event2',
                    allDay: false,
                    start: new Date(2022, 2, 9), // 실제 month = month + 1
                    end: new Date(2022, 2, 9),
                    resource: 'hi',
                  },
                ]}
                startAccessor="start"
                endAccessor="end"
                style={{ height: 500 }}
                // components={{
                //   toolbar: 'Toolbar',
                //   month: {
                //     dateHeader: <div>+</div>,
                //   },
                // }}
              />
            </CCardBody>
          </CCard>
        </CCol>

        <CCol lg="3">
          <CCard style={{ height: 535 }}>
            <CCardBody>
              {'2020-03'} 현황
              <CRow className="mt-4">
                <CInputGroup className="mb-3">
                  <CInputGroupText id="basic-addon3">입금</CInputGroupText>
                  <StyledCFormInput value={1000} disabled />
                  <CInputGroupText id="basic-addon3">원</CInputGroupText>
                </CInputGroup>
              </CRow>
              <CRow>
                <CInputGroup className="mb-3">
                  <CInputGroupText id="basic-addon3">지출</CInputGroupText>
                  <StyledCFormInput disabled />
                  <CInputGroupText id="basic-addon3">원</CInputGroupText>
                </CInputGroup>
              </CRow>
              <CRow>
                <CInputGroup className="mb-3">
                  <CInputGroupText id="basic-addon3">총 합계</CInputGroupText>
                  <StyledCFormInput disabled />
                  <CInputGroupText id="basic-addon3">원</CInputGroupText>
                </CInputGroup>
              </CRow>
            </CCardBody>
          </CCard>
        </CCol>
      </CRow>
    </div>
  )
}

export default AccountBook
