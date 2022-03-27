import React, { useState } from 'react'
import { useHistory } from 'react-router-dom'

import {
  CButton,
  CCard,
  CCardBody,
  CCol,
  CContainer,
  CForm,
  CFormInput,
  CInputGroup,
  CInputGroupText,
  CRow,
} from '@coreui/react'
import CIcon from '@coreui/icons-react'
import { cilLockLocked, cilUser } from '@coreui/icons'
import axios from 'axios'

const Register = () => {
  const history = useHistory()

  const [user, setUser] = useState({
    name: '',
    email: '',
    password: '',
    repeatPassword: '',
  })

  const onClick_createUser = () => {
    if (registerAble(user)) {
      let userData = {
        userName: user.name,
        email: user.email,
        password: user.password,
      }

      axios('/v1/user', {
        method: 'POST',
        data: userData,
      }).then((res) => {
        history.push({
          pathname: '/login',
        })
      })
    } else {
      // 경고 창
    }
  }

  const registerAble = (user) => {
    return user.password === user.repeatPassword
  }

  const onChange_UserInfoes = (e) => {
    let name = e.target.name
    let value = e.target.value

    setUser({
      ...user,
      [name]: value,
    })
  }

  return (
    <div className="bg-light min-vh-100 d-flex flex-row align-items-center">
      <CContainer>
        <CRow className="justify-content-center">
          <CCol md={9} lg={7} xl={6}>
            <CCard className="mx-4">
              <CCardBody className="p-4">
                <CForm>
                  <h1>Register</h1>
                  <p className="text-medium-emphasis">Create your account</p>
                  <CInputGroup className="mb-3">
                    <CInputGroupText>
                      <CIcon icon={cilUser} />
                    </CInputGroupText>
                    <CFormInput
                      placeholder="Username"
                      autoComplete="username"
                      name="name"
                      onChange={(e) => onChange_UserInfoes(e)}
                    />
                  </CInputGroup>
                  <CInputGroup className="mb-3">
                    <CInputGroupText>@</CInputGroupText>
                    <CFormInput
                      placeholder="Email"
                      autoComplete="email"
                      name="email"
                      onChange={(e) => onChange_UserInfoes(e)}
                    />
                  </CInputGroup>
                  <CInputGroup className="mb-3">
                    <CInputGroupText>
                      <CIcon icon={cilLockLocked} />
                    </CInputGroupText>
                    <CFormInput
                      type="password"
                      name="password"
                      placeholder="Password"
                      autoComplete="new-password"
                      onChange={(e) => onChange_UserInfoes(e)}
                    />
                  </CInputGroup>
                  <CInputGroup className="mb-4">
                    <CInputGroupText>
                      <CIcon icon={cilLockLocked} />
                    </CInputGroupText>
                    <CFormInput
                      type="password"
                      name="repeatPassword"
                      placeholder="Repeat password"
                      autoComplete="new-password"
                      onChange={(e) => onChange_UserInfoes(e)}
                    />
                  </CInputGroup>
                  <div className="d-grid">
                    <CButton color="success" onClick={onClick_createUser}>
                      Create Account
                    </CButton>
                  </div>
                </CForm>
              </CCardBody>
            </CCard>
          </CCol>
        </CRow>
      </CContainer>
    </div>
  )
}

export default Register
